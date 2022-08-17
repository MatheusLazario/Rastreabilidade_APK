package com.example.consulta.dao;

import com.example.consulta.conexao.conexao;
import com.example.consulta.model.pecas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class pecasDAO {
    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public pecas consulta(String serial) {

        try {
            pecas pec = new pecas();
            Connection conn = conexao.conectar();
            if (conn != null) {

                String sql = "select i.partNumber_tampa_bruto+i.serial_tampa_bruto+i.lote_tampa_bruto as MainDMCHous,i.partNumber_bruto+i.serial_bruto+i.lote_bruto as MainDMCCover,i.FCA_partNumber+i.partNumber+i.dataJuliana+CAST(i.ultDigitoAno AS varchar)+'L'+i.serial+i.suplierCode+i.lote as MainFinalDMC,i.aprovado,i.data_hora as HoraFinal,usu.nome as OperadorFinal,usi.part_number_usi+usi.serial_item+usi.lote_usinagem as SerialUsinagem, usuusi.nome as OperadorUsinagem,usi.data_hora as HoraUsinagem,usi.maquina as MaquinaUsinagem, usuinj.nome as OperadorInjecao,inj.data_hora as HoraInjecao,inj.maquina as MaquinaInjecao\n" +
                        "\n" +
                        "from InspecaoMontagem_FrontCover_CVT as i\n" +
                        "\n" +
                        "join injecao inj on inj.part_number = i.partNumber_bruto and inj.serial_item = i.serial_bruto and inj.lote_item = i.lote_bruto\n" +
                        "\n" +
                        "join Usinagem usi on usi.part_number_item = i.partNumber_bruto and usi.serial_item = i.serial_bruto and usi.lote_item = i.lote_bruto\n" +
                        "\n" +
                        "join usuarios usu on usu.codus = i.cod_operador\n" +
                        "\n" +
                        "join usuarios usuinj on usuinj.codus = inj.cod_operador\n" +
                        "\n" +
                        "join usuarios usuusi on usuusi.codus = usi.cod_operador\n" +
                        "\n" +
                        "where i.FCA_partNumber+i.partNumber+i.dataJuliana+CAST(i.ultDigitoAno AS varchar)+'L'+i.serial+i.suplierCode+i.lote = '" + serial + "'";


                String sql1 = "select i.partNumber_tampa_bruto+i.serial_tampa_bruto+i.lote_tampa_bruto as MainDMCHous,i.partNumber_bruto+i.serial_bruto+i.lote_bruto as MainDMCCover,i.FCA_partNumber+i.partNumber+i.dataJuliana+CAST(i.ultDigitoAno AS varchar)+'L'+i.serial+i.suplierCode+i.lote as MainFinalDMC,i.aprovado,i.data_hora as HoraFinal,usu.nome as OperadorFinal,usi.part_number_usi+usi.serial_item+usi.lote_usinagem as SerialUsinagem, usuusi.nome as OperadorUsinagem,usi.data_hora as HoraUsinagem,usi.maquina as MaquinaUsinagem, usuinj.nome as OperadorInjecao,inj.data_hora as HoraInjecao,inj.maquina as MaquinaInjecao\n" +
                        "\n" +
                        "from InspecaoMontagem_FrontCover_T3T4 as i\n" +
                        "\n" +
                        "join injecao inj on inj.part_number = i.partNumber_bruto and inj.serial_item = i.serial_bruto and inj.lote_item = i.lote_bruto\n" +
                        "\n" +
                        "join Usinagem usi on usi.part_number_item = i.partNumber_bruto and usi.serial_item = i.serial_bruto and usi.lote_item = i.lote_bruto\n" +
                        "\n" +
                        "join usuarios usu on usu.codus = i.cod_operador\n" +
                        "\n" +
                        "join usuarios usuinj on usuinj.codus = inj.cod_operador\n" +
                        "\n" +
                        "join usuarios usuusi on usuusi.codus = usi.cod_operador\n" +
                        "\n" +
                        "where i.FCA_partNumber+i.partNumber+i.dataJuliana+CAST(i.ultDigitoAno AS varchar)+'L'+i.serial+i.suplierCode+i.lote = '" + serial + "'";
                Statement st = null;
                st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);//CVT 950

                if (rs.next()) {//verifica se a consulta encontrou o serial
                    pec.setMainDMCHous(rs.getString("MainDMCHous"));
                    pec.setMainDMCCover(rs.getString("MainDMCCover"));
                    pec.setMainFinalDMC(rs.getString("MainFinalDMC"));
                    pec.setAprovado((rs.getString("Aprovado")));
                    pec.setHoraFinal(rs.getString("HoraFinal"));
                    pec.setOperadorFinal(rs.getString("OperadorFinal"));
                    pec.setSerialUsinagem(rs.getString("SerialUsinagem"));
                    pec.setOperadorUsinagem(rs.getString("OperadorUsinagem"));
                    pec.setHoraUsinagem(rs.getString("HoraUsinagem"));
                    pec.setMaquinaUsinagem(rs.getString("MaquinaUsinagem"));
                    pec.setOperadorInjecao(rs.getString("OperadorInjecao"));
                    pec.setHoraInjecao(rs.getString("HoraInjecao"));
                    pec.setMaquinaInjecao(rs.getString("MaquinaInjecao"));


                    return pec;

                }
                ResultSet rs1 = st.executeQuery(sql1);//T3T4 650
                if (rs1.next()) {
                    pec.setMainDMCHous(rs1.getString("MainDMCHous"));
                    pec.setMainDMCCover(rs1.getString("MainDMCCover"));
                    pec.setMainFinalDMC(rs1.getString("MainFinalDMC"));
                    pec.setAprovado((rs1.getString("Aprovado")));
                    pec.setHoraFinal(rs1.getString("HoraFinal"));
                    pec.setOperadorFinal(rs1.getString("OperadorFinal"));
                    pec.setSerialUsinagem(rs1.getString("SerialUsinagem"));
                    pec.setOperadorUsinagem(rs1.getString("OperadorUsinagem"));
                    pec.setHoraUsinagem(rs1.getString("HoraUsinagem"));
                    pec.setMaquinaUsinagem(rs1.getString("MaquinaUsinagem"));
                    pec.setOperadorInjecao(rs1.getString("OperadorInjecao"));
                    pec.setHoraInjecao(rs1.getString("HoraInjecao"));
                    pec.setMaquinaInjecao(rs1.getString("MaquinaInjecao"));
                    return pec;
                } else {
                    return null;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}





