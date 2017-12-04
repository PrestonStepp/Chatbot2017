package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Need import for scrollpane
import javax.swing.JScrollPane;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JScrollPane chatScrollPane;
	//Need a data member for the scrollpane
	
	private JLabel infoLabel;

	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;

		// Initialize GUI data members
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(25);
		infoLabel = new JLabel("Type to chat with the chatbot");
		appLayout = new SpringLayout();
		//init the scrollpane
		checkerButton = new JButton("Check contents");
		chatScrollPane = new JScrollPane();
		//call new helper method
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(infoLabel);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);

	}

	private void setupLayout()
	{

	}

	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
	}
}
