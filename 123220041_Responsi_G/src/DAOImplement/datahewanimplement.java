/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import model.*;
import java.util.List;



public interface datahewanimplement {
    public void insert(datahewan h);
    public void update (datahewan h);
    public void delete (Integer id);
    
    public List<datahewan> getAll();
}
