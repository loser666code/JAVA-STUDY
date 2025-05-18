package model;

public class User {
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String cargo;
    private String username;

    public User(int id, String nome, String sobrenome, String email, String senha, String cargo, String username) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.username = username;
    }
    
    public User( String nome, String sobrenome, String email, String senha, String cargo, String username) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.username = username;
    }
    
    public User(String email, String senha, String cargo, String username) {
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.username = username;
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
    
    
}
