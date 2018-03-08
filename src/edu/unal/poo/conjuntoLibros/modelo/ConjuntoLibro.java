/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.poo.conjuntoLibros.modelo;
import java.util.ArrayList;
/**
 *
 * @author Estudiante
 */
public class ConjuntoLibro {
        //Asociacion
    private ArrayList<Libro> libros;
    //private HashMap<String, Libro> libros; ---- busqueda por titulo(String)

    public ConjuntoLibro() {
      this.libros = new ArrayList();
      //this.libros= new HashMap<>();
    }
    
    public boolean anadirLibro(Libro libro){
       return this.libros.add(libro);
       //return this.libros.put(libro.getTitulo(), libro);
    }
       
    
    public ArrayList<Libro> mostrarLibros(){
      return this.libros;
    }
    
    public boolean eliminarxAutor(String nombre){
       boolean resultado = false;
       for (int i = 0; i < this.libros.size(); i++) {
           Autor autor = this.libros.get(i).getAutor();
           if(autor.getNombre().equals(nombre)){
              Libro l= this.libros.remove(i);
              if(l!=null){    
              resultado = true;
           }  
         }
       }
       return resultado;
    }
    public boolean eliminarxTitulo(String titulo){
       boolean resultado = false;
       for(Libro libro: libros){
           if (libro.getTitulo().equals(titulo)){
                  return this.libros.remove(libro);
              }
       }
       return resultado;
    }
    
    public Libro buscarMejorCalificado(){
      Libro mayorCalificacion = null;
      for (Libro libro: libros) {
         if(libro != null && mayorCalificacion == null){
           mayorCalificacion = libro;
         }else{
            if(libro!= null && libro.getCalificacion() > mayorCalificacion.getCalificacion()){
              mayorCalificacion = libro;
            }
         }
      }
      return mayorCalificacion;
    }
    
    public Libro buscarMenorCalificado(){
      Libro menorCalificacion = null;
      for (Libro libro: libros) {
         if(libro != null && menorCalificacion == null){
           menorCalificacion = libro;
         }else{
            if(libro!= null && libro.getCalificacion() < menorCalificacion.getCalificacion()){
              menorCalificacion = libro;
            }
         }
      }
      return menorCalificacion;
    }
    
    
    public boolean calificarLibro(String titulo, int valor){
        for (Libro libro: libros) {
           if(libro!= null && libro.getTitulo().equals(titulo)){
             libro.setCalificacion(valor);
                return true;
           }     
        }
        return false;    
    }
    
}
