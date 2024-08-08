package com.innefu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


	

	@Controller
	public class ChatController {

	    @GetMapping("/chat-page")
	    @ResponseBody
	    public String getChatPage() {
	        return "<!DOCTYPE html>" +
	               "<html>" +
	               "<body>" +
	               "<h2>WebSocket Chat</h2>" +
	               "<input id='messageInput' type='text' placeholder='Type a message...'/>" +
	               "<button onclick='sendMessage()'>Send</button>" +
	               "<ul id='messages'></ul>" +
	               "<script>" +
	               "var ws = new WebSocket('ws://localhost:8080/chat');" +
	               "ws.onmessage = function(event) {" +
	               "  var messages = document.getElementById('messages');" +
	               "  var message = document.createElement('li');" +
	               "  message.textContent = event.data;" +
	               "  messages.appendChild(message);" +
	               "};" +
	               "function sendMessage() {" +
	               "  var input = document.getElementById('messageInput');" +
	               "  ws.send(input.value);" +
	               "  input.value = '';" +
	               "}" +
	               "</script>" +
	               "</body>" +
	               "</html>";
	    }
	}

	
	

