package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

public class ChatbotController
{ 
	private Chatbot chatbot;
	private PopupDisplay displ;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Preston Stepp");
		
		display = new PopupDisplay();
		appFrame = new ChaFrame(this);
	}
}
