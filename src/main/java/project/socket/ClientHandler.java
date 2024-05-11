package project.socket;


import com.mysql.cj.protocol.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler extends Thread{
    private ArrayList <ClientHandler> clients;
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private List<Message> messages;

    public ClientHandler(ArrayList<ClientHandler> clients, Socket socket) {
        try {
            this.clients = clients;
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//    @Override
//    public void run() {
//        String announcement;
//        try {
//            while ((announcement = bufferedReader.readLine()) != null) {
//                for(ClientHandler c : clients) {
//                    c.printWriter.println(announcement);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                socket.close();
//                bufferedReader.close();
//                printWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = bufferedReader.readLine()) != null) {
                broadcastMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void broadcastMessage(String message) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (!client.equals(this)) {
                    client.printWriter.println(message);
                }
            }
        }
    }

    private void closeResources() {
        try {
            if (socket != null) {
                socket.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
