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

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
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
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 41, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);

		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
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
