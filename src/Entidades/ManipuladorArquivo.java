package Entidades;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ManipuladorArquivo {

    public static void gravarVeiculos(ArrayList<Veiculo> veiculos) {

        try {
            ObjectOutputStream arqObj = new ObjectOutputStream(new FileOutputStream("src\\Dados\\Veiculos.dat"));
            arqObj.writeObject(veiculos);
            arqObj.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante gravação dos veiculos. Arquivo não encontrado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro durante gravação dos veiculos. Aquivo não encontrado");
        }
    }

    public static void gravarClientes(ArrayList<Cliente> clientes) {

        try {
            ObjectOutputStream arqObj = new ObjectOutputStream(new FileOutputStream("src\\Dados\\Clientes.dat"));
            arqObj.writeObject(clientes);
            arqObj.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante gravação. Arquivo não encontrado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro durante gravação . Aquivo não encontrado");
        }
    }

    public static ArrayList<Veiculo> lerVeiculos() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        try {

            ObjectInputStream leitor = new ObjectInputStream(new FileInputStream("src\\Dados\\Veiculos.dat"));
            veiculos = (ArrayList<Veiculo>) leitor.readObject();
            leitor.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro durante leitura dos veiculos. Arquivo não encontrado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro durante leitura dos veiculos. Aquivo não encontrado");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro durante leitura dos veiculos. Classe não encontrada");
        }


        return veiculos;

    }

    public static ArrayList<Cliente> lerClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {

            ObjectInputStream leitor = new ObjectInputStream(new FileInputStream("src\\Dados\\Clientes.dat"));
            clientes = (ArrayList<Cliente>) leitor.readObject();
            leitor.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante leitura dos clientes. Arquivo não encontrado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante leitura dos clientes. Aquivo não encontrado");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante leitura dos clientes. Classe não encontrada");
        }

        return clientes;
    }
}
