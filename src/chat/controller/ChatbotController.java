package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

public class ChatbotController
{ 
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Preston Stepp");
		//View initialized after Model
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		display.displayText("Welcome to Chatbot");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}
	
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		chatbot.processConversation(input);
		
		return chatbotSays;
	}

	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		
		
		
		return response;
	}

	
	
	
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}	
}