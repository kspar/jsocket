package jsocket.socket;

import jsocket.cipher.Crypto;
import jsocket.exceptions.InstantiationException;
import jsocket.exceptions.SocketStreamException;
import jsocket.exceptions.UnsetCryptographicServiceException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Basic Socket abstraction
 * @author Will Czifro
 */
public class SocketImpl implements Socket {

    //////// Base variables ////////
    private java.net.Socket conn;
    private DataInputStream in;
    private DataOutputStream out;
    private int bufferSize;
    ////////////////////////////////

    public SocketImpl(java.net.Socket conn) {
        try {
            this.conn = conn;
            this.in = new DataInputStream(conn.getInputStream());
            this.out = new DataOutputStream(conn.getOutputStream());
        } catch (Exception e) {
            close();
            throw new InstantiationException(e);
        }
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public byte[] receive() {
        return receiveAll(bufferSize);
    }

    public byte[] receiveAll(int size) {
        try {
            byte[] data = new byte[size];
            in.read(data, 0, size);
            return data;
        } catch (Exception e) {
            throw new SocketStreamException("Error receiving data", e);
        }
    }

    public void send(byte[] data) {
        try {
            out.write(data, 0, data.length);
        } catch (Exception e) {
            throw new SocketStreamException("Error sending data", e);
        }
    }

    public void close() {
        try {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
            if (conn != null)
                conn.close();
        } catch (IOException e) {
            throw new SocketStreamException("Error when closing connection", e);
        } finally {
            in = null;
            out = null;
            conn = null;
        }
    }

    protected int getBufferSize() {
        return bufferSize;
    }
}
