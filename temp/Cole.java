
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Cole extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 3271832943183613027L;
	static String FILE_PATH = "datafile.txt";
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf3, tf5, tf6, tf7;
    JButton btn1, btn2, btn3, btn4;
    JPasswordField p1, p2;
    HashMap<String,Person> data;
    
	public Cole()
	{
		data = new HashMap<String,Person>();
		readFromFile(FILE_PATH, data);
		initUI();
	}
	
	private void initUI()
	{
		setVisible(true);
		setTitle("Enter Your Data");
		setSize(700, 700);
		getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel("Name:");
        l2 = new JLabel("Age:");
        l3 = new JLabel("MidName:");
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        
        btn1 = new JButton("Add");
        btn2 = new JButton("Update");
        btn3 = new JButton("Delete");
        btn4 = new JButton("Quit");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        
        l1.setBounds(80, 70, 200, 30);
        l2.setBounds(80, 110, 200, 30);
        l3.setBounds(80, 150, 200, 30);
        
        tf1.setBounds (300, 70, 205, 32);
        tf2.setBounds(300, 110, 200, 30);
        tf3.setBounds(300, 150, 200, 30);
        
        btn1.setBounds(50, 350, 100, 30);
        btn2.setBounds(170, 350, 100, 30);
        btn3.setBounds(50, 450, 100, 30);
        btn4.setBounds(170, 450, 100, 30);
        
        getContentPane().add(l1);
        getContentPane().add(tf1); 
        getContentPane().add(l2);
        getContentPane().add(tf2);
        getContentPane().add(l3);
        getContentPane().add(tf3);
        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(btn3);
        getContentPane().add(btn4);
	}

	public static void main(String[] args) 
	{
        EventQueue.invokeLater(new Runnable() {
        
            public void run() 
            {
            	new Cole();
            }
        });
	}
	
	public void actionPerformed(ActionEvent event) 
	{
	    String name = tf1.getText();
        int age = Integer.parseInt(tf2.getText());          
        String midname = tf3.getText();
        
        String key = name+"~"+age;
        
        Person p = new Person(name, age,midname);
		if(event.getSource() == btn1) // ADD
		{
			if(!data.containsKey(key))
			{
				data.put(key, p); 
				writeToFile(FILE_PATH, data);
			}
			else
			{
				System.out.println("data already present");
			}
		}
		else if(event.getSource() == btn2)  // Update
		{
		    if(data.containsKey(key))
            {
		        data.put(key, p); 	writeToFile(FILE_PATH, data);
            }
            else
            {
                System.out.println("data not available!! So entering a new entry!!");
            }
		}
		else if(event.getSource() == btn3)  // Delete
		{ 
						data.remove(key);
						writeToFile(FILE_PATH, data);
						

		}
		else  //Save  for Quit
		{
		    writeToFile(FILE_PATH, data);
		}
	}


    private void readFromFile(String path, HashMap<String, Person> dataTemp) 
	{
		try
		{
		    File f = new File(path);
			FileInputStream fis = new FileInputStream(f);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		 
			String line = null;
			while ((line = br.readLine()) != null) 
			{
				String[] linedata = line.split("\t");
				Person p = new Person(linedata[0], Integer.parseInt(linedata[1]),linedata[2]);
				String key =p.name+"~"+p.age;
				dataTemp.put(key, p);
			}
			br.close();
		}
		catch(Throwable t)
		{
			System.out.println("error on reading from file"+t);
		}
	}
	
	private void writeToFile(String filepath, HashMap<String, Person> dataTemp) 
	{
		try
		{		
			FileWriter f = new FileWriter(filepath);
			Iterator<String> itr =  dataTemp.keySet().iterator();
			
			while(itr.hasNext())
			{
				Person p = data.get(itr.next());
				f.write(p.name+"\t"+p.age+"\t"+p.middlename+"\r\n");
			}
			f.close();
			//System.out.println("fileee");

			
		}
		catch(Throwable t)
		{
			System.out.println("error: "+ t);
		}
		
	}
}

class Person
{
	public String name;
	public int age;
	public String middlename;
	
    public Person(String name, int age, String middlename) 
	{
		this.name = name;
		this.age = age;
		this.middlename = middlename;
	}
}
