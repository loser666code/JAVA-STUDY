package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String cargo;
    private String username;
    private String telefone;
    private String aniversario;

    public User(int id, String nome, String sobrenome, String email, String senha, String cargo, String username, String telefone, String aniversario) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.username = username;
        this.telefone = telefone;
        this.aniversario = aniversario;
    }
    
    public User( String nome, String sobrenome, String email, String senha, String cargo, String username, String telefone, String aniversario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.username = username;
        this.telefone = telefone;
        this.aniversario = aniversario;
    }
    
    public User(String email, String senha, String cargo, String username, String telefone, String aniversario) {
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.username = username;
        this.telefone = telefone;
        this.aniversario = aniversario;
    }
    
    public User() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }
    
    private transient IntegerProperty idProperty;
    
    public IntegerProperty idProperty(){
        if (idProperty == null){
            idProperty = new SimpleIntegerProperty(id);
        }
        return idProperty;
    }
    
    private transient StringProperty nomeProperty;
    
    public StringProperty nomeProperty(){
        if (nomeProperty == null){
            nomeProperty = new SimpleStringProperty(nome);
        }
        return nomeProperty;
    }
    
    private transient StringProperty sobrenomeProperty;
    
    public StringProperty sobrenomeProperty(){
        if (sobrenomeProperty == null){
            sobrenomeProperty = new SimpleStringProperty(sobrenome);
        }
        return sobrenomeProperty;
    }
    
    private transient StringProperty emailProperty;
    
    public StringProperty emailProperty(){
        if (emailProperty == null){
            emailProperty = new SimpleStringProperty(email);
        }
        return emailProperty;
    }
    
    private transient StringProperty senhaProperty;
    
    public StringProperty senhaProperty(){
        if (senhaProperty == null){
            senhaProperty = new SimpleStringProperty(senha);
        }
        return senhaProperty;
    }
    
    private transient StringProperty cargoProperty;
    
    public StringProperty cargoProperty(){
        if (cargoProperty == null){
            cargoProperty = new SimpleStringProperty(cargo);
        }
        return cargoProperty;
    }
    
    private transient StringProperty usernameProperty;
    
    public StringProperty usernameProperty(){
        if (usernameProperty == null){
            usernameProperty = new SimpleStringProperty(username);
        }
        return usernameProperty;
    }
    
    private transient StringProperty telefoneProperty;
    
    public StringProperty telefoneProperty(){
        if (telefoneProperty == null){
            telefoneProperty = new SimpleStringProperty(telefone);
        }
        return telefoneProperty;
    }
    
    private transient StringProperty aniversarioProperty;
    
    public StringProperty aniversarioProperty(){
        if (aniversarioProperty == null){
            aniversarioProperty = new SimpleStringProperty(aniversario);
        }
        return aniversarioProperty;
    }
}
