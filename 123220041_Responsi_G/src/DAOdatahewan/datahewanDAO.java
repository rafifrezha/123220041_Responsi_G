/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatahewan;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.datahewanimplement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class datahewanDAO implements datahewanimplement{
    Connection connection;
    
    final String select = "SELECT * FROM titip_hewan";
    final String insert = "INSERT INTO titip_hewan(nama_pemilik, nama_hewan, jenis_hewan, nomor_telepon, durasi_titip, total_biaya) VALUES (?,?,?,?,?,?);";
    final String update = "UPDATE titip_hewan set nama_pemilik=?, nama_hewan=?, jenis_hewan=?, nomor_telepon=?, durasi_titip=?, total_biaya=? where id=?;";
    final String delete = "DELETE from titip_hewan where id=?;";
    
    public datahewanDAO(){
        connection = connector.connection();
    }
    
    @Override
    public void insert(datahewan h) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, h.getNama_pemilik());
            statement.setString(2, h.getNama_hewan());
            statement.setString(3, h.getJenis_hewan());
            statement.setString(4, h.getNomor_telepon());
            statement.setInt(5, h.getDurasi_titip());
            int biayaDasar = 100000;
            int tambahanhari = 50000;
            int total;
            
            if(h.getDurasi_titip() <= 2){
                total = h.getDurasi_titip()*biayaDasar;
            }
            else{
                int biayaAwal = 2 * biayaDasar;
                int Tambahan = h.getDurasi_titip() - 2;
                int biayaTambahan = Tambahan * (biayaDasar + tambahanhari);
                total = biayaAwal + biayaTambahan;
            }
            statement.setInt(5, total);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                h.setId(rs.getInt(1));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();  
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datahewan h) {
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(update);
            
            statement.setString(1, h.getNama_pemilik());
            statement.setString(2, h.getNama_hewan());
            statement.setString(3, h.getJenis_hewan());
            statement.setString(4, h.getNomor_telepon());
            statement.setInt(5, h.getDurasi_titip());
            int biayaDasar = 100000;
            int tambahanhari = 50000;
            int total;
            
            if(h.getDurasi_titip() <= 2){
                total = h.getDurasi_titip()*biayaDasar;
            }
            else{
                int biayaAwal = 2 * biayaDasar;
                int Tambahan = h.getDurasi_titip() - 2;
                int biayaTambahan = Tambahan * (biayaDasar + tambahanhari);
                total = biayaAwal + biayaTambahan;
            }
            statement.setInt(5, total);
            statement.setInt(6, h.getId());
            statement.executeUpdate();
          
        }catch(SQLException ex){
            ex.printStackTrace();  
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();  
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datahewan> getAll() {
        List<datahewan> dh = null;
        try{
            dh = new ArrayList<datahewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datahewan h = new datahewan();
                h.setId(rs.getInt("id"));
                h.setNama_pemilik(rs.getString("nama_pemilik"));
                h.setNama_hewan(rs.getString("nama_hewan"));
                h.setJenis_hewan(rs.getString("jenis_hewan"));
                h.setNomor_telepon(rs.getString("nomor_telepon"));
                h.setDurasi_titip(rs.getInt("durasi_titip"));
                h.setTotal_biaya(rs.getInt("total_biaya"));
                dh.add(h);
            }
        }catch(SQLException ex){
            Logger.getLogger(datahewanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dh;
    }
}
    
