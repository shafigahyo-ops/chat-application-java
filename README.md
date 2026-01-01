# Online Chat Application (Java)

## Overview

This project is a simple online chat application built using Java socket programming.  
It follows a client-server model where multiple clients connect to one server and exchange messages in real time using a text-based interface.

The application demonstrates:
- Socket programming  
- Client-server communication  
- Multithreading  
- Basic user management  
- Message broadcasting  

---

## Project Files

- **ChatServer.java** – Starts the server and manages client connections  
- **ClientHandler.java** – Handles communication with one client  
- **ChatClient.java** – Connects a user to the server and sends/receives messages  

---

## Requirements

- Java JDK 8 or later  
- VS Code or any Java-supported IDE  
- Command line / terminal access  

---

## How to Compile the Program

1. Place all files in the same folder:
   - ChatServer.java  
   - ClientHandler.java  
   - ChatClient.java  

2. Open a terminal in that folder.

3. Compile the files:
   ```bash
   javac ChatServer.java ClientHandler.java ChatClient.java

--

## How to Run the Application
1. Open a terminal and run: java ChatServer
2. Start Clients: Open a new terminal window for each user and run java ChatClient

Each client will:
1. Receive a unique user ID
2. See messages from other connected users
3. Send messages by typing and pressing Enter

--

## How the Application Works

1. The server listens on port 5000
2. Each client connection runs in a separate thread
3. The server assigns a unique user ID to each user
4. Messages from one client are broadcast to all connected clients
5. The client interface is text-based and runs in the terminal
# output
Connected to chat server

Welcome! You are User 1

User 1 joined the chat.

User 2 joined the chat.

User 2: Hi

Hello

User 1: Hello

User 2: How are you?

Fine, and you?

User 1: Fine, and you?

User 2: I'm good. it's new year !

Yeah ! time waits for no one ..

User 1: Yeah ! time waits for no one ..

User 3 joined the chat.

User 2 left the chat.

