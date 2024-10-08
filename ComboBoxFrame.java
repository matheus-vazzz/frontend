
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; // hold icon names
   private final JLabel label; // displays selected icon

   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   private final Icon[] icons = { 
      new ImageIcon(getClass().getResource(names[0])), // declaração de 4 novos objetos, com dois parâmetros cada dentro dos parenteses (getClass p pegar a classe e o getResource para pegar o arquivo da imagem)
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};

   // ComboBoxFrame constructor adds JComboBox to JFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox");
      setLayout(new FlowLayout()); // set frame layout     

      imagesJComboBox = new JComboBox<String>(names); // set up JComboBox
      imagesJComboBox.setMaximumRowCount(3); // define a quantidade de linhas que serão exibidas sem rolar a barrinha

      imagesJComboBox.addItemListener(
         new ItemListener() // anonymous inner class
         {
            // handle JComboBox event
            @Override
            public void itemStateChanged(ItemEvent event)
            {
               // determine whether item selected
               if (event.getStateChange() == ItemEvent.SELECTED) // quando selecionado um item que já está selecionado, não altera, apenas coleta se selecionar um diferente
                  label.setIcon(icons[
                     imagesJComboBox.getSelectedIndex()]);
            } 
         } // end anonymous inner class
      ); // end call to addItemListener

      add(imagesJComboBox); // add combobox to JFrame
      label = new JLabel(icons[0]); // display first icon
      add(label); // add label to JFrame
   }
} 