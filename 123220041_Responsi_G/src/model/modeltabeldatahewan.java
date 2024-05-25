/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class modeltabeldatahewan extends AbstractTableModel{
    List<datahewan> dh;

    public modeltabeldatahewan(List<datahewan> dh) {
        this.dh = dh;
    }
      
    @Override
    public int getRowCount() {
        return dh.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Id";
            case 1:
                return "Nama Pemilik";
            case 2:
                return "Nama Hewan";
            case 3:
                return "Jenis Hewan";
            case 4:
                return "Nomor Telepon";
            case 5:
                return "Durasi Titip";
            case 6:
                return "Total Biaya";
            default :
            return null;
                
        }
    }
    

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dh.get(row).getId();
            case 1:
                return dh.get(row).getNama_pemilik();
            case 2:
                return dh.get(row).getNama_hewan();
            case 3:
                return dh.get(row).getJenis_hewan();
            case 4:
                return dh.get(row).getNomor_telepon();
            case 5:
                return dh.get(row).getDurasi_titip();
            case 6:
                return dh.get(row).getTotal_biaya();
            default :
            return null;
                
        }
    }
    
}
