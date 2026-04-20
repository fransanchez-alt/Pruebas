package com.fran.apidemo;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

public class JugadorService {

    private static final String DATABASE_FILE = "jugadores.neodatis";

    public void inicializarDatos() {
        ODB odb = null;
        try {
            odb = ODBFactory.open(DATABASE_FILE);

            // Verificar si ya hay datos
            Objects<Jugador> jugadores = odb.getObjects(Jugador.class);
            if (jugadores.isEmpty()) {
                // Agregar más jugadores de ejemplo para una base de datos mayor
                Jugador j1 = new Jugador(1L, "Messi", "Delantero", 36);
                Jugador j2 = new Jugador(2L, "Ronaldo", "Delantero", 38);
                Jugador j3 = new Jugador(3L, "Neymar", "Delantero", 31);
                Jugador j4 = new Jugador(4L, "Mbappé", "Delantero", 24);
                Jugador j5 = new Jugador(5L, "Haaland", "Delantero", 23);
                Jugador j6 = new Jugador(6L, "Modric", "Centrocampista", 37);
                Jugador j7 = new Jugador(7L, "De Bruyne", "Centrocampista", 32);
                Jugador j8 = new Jugador(8L, "Benzema", "Delantero", 35);
                Jugador j9 = new Jugador(9L, "Pedri", "Centrocampista", 20);
                Jugador j10 = new Jugador(10L, "Vinicius", "Delantero", 23);
                Jugador j11 = new Jugador(11L, "Salah", "Delantero", 31);
                Jugador j12 = new Jugador(12L, "Mane", "Delantero", 31);
                Jugador j13 = new Jugador(13L, "Kane", "Delantero", 30);
                Jugador j14 = new Jugador(14L, "Son", "Delantero", 30);
                Jugador j15 = new Jugador(15L, "Lewandowski", "Delantero", 34);

                odb.store(j1);
                odb.store(j2);
                odb.store(j3);
                odb.store(j4);
                odb.store(j5);
                odb.store(j6);
                odb.store(j7);
                odb.store(j8);
                odb.store(j9);
                odb.store(j10);
                odb.store(j11);
                odb.store(j12);
                odb.store(j13);
                odb.store(j14);
                odb.store(j15);

                System.out.println("Datos iniciales almacenados en Neodatis (15 jugadores).");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

    public List<Jugador> obtenerTodosLosJugadores() {
        ODB odb = null;
        List<Jugador> jugadores = new ArrayList<>();
        try {
            odb = ODBFactory.open(DATABASE_FILE);
            Objects<Jugador> objects = odb.getObjects(Jugador.class);
            while (objects.hasNext()) {
                jugadores.add(objects.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        return jugadores;
    }

    public Jugador obtenerJugadorPorId(Long id) {
        ODB odb = null;
        try {
            odb = ODBFactory.open(DATABASE_FILE);
            CriteriaQuery query = new CriteriaQuery(Jugador.class, Where.equal("id", id));
            Objects<Jugador> objects = odb.getObjects(query);
            if (objects.hasNext()) {
                return objects.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
        return null;
    }
}