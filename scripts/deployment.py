#!/usr/bin/env python
import sys
import os
import re
import shlex
import subprocess
import config
import maven_settings_editor
import pom_editor

def __get_repo_type():
    branch = os.environ["TRAVIS_BRANCH"]
    if branch.startswith(config.RELEASE_BRANCH_PREFIX):
        return config.REPO_TYPES[2]
    elif re.match(config.STAGING_BRANCH_PATTERN, branch) is not None:
        return config.REPO_TYPES[1]
    elif branch in config.SNAPSHOT_BRANCHES:
        return config.REPO_TYPES[0]
    else:
        return None

def __do_mvn_deploy():
    cmd = 'mvn clean deploy --settings ' + maven_settings_editor.settings_path()
    args = shlex.split(cmd)
    mvn = subprocess.Popen(args)
    out, err = mvn.communicate()
    print out # need to print stdout before stderr
    if out.rfind('[ERROR]') is not None:
        print "Failed to deploy"
        sys.exit(0)

def deploy():
    if os.environ["TRAVIS_SECURE_ENV_VARS"] == "false":
        print "no secure env vars available, skipping deployment"
        sys.exit()

    repo_type = __get_repo_type()
    print "Using maven repo: " + repo_type
    print "Adjusting version in pom.xml..."
    v = pom_editor.set_project_version((repo_type == config.REPO_TYPES[0]), config.BETA, config.BETA_VAL)
    print "Set version to " + v
    print "Adjusting distribution management config in pom.xml..."
    pom_editor.add_repo_to_pom(repo_type)

    user = os.environ["JSOCKET_USERNAME"]
    pwd = os.environ["JSOCKET_PASSWORD"]

    print "Configuring maven settings..."
    maven_settings_editor.setup_settings(repo_type, user, pwd)

    print "Deploying to maven...\n\n"
    __do_mvn_deploy()

