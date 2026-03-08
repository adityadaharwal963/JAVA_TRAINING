package com.rcoem.project2;

import java.util.List;
import java.util.stream.Collectors;

public  class Service {
    private static int counter = 100;
    public List<Empolyee> viewAll(){
        return DAO.getEmpolyee();
    }
    public  Empolyee addEmpolyee(String name, Double salary, String designation, String gender, int yearOfJoining){
        counter++;
        Empolyee e = new Empolyee();
        e.setId(counter);
        e.setName(name);
        e.setDesignation(designation);
        e.setGender(gender);
        e.setYearOfJoining(yearOfJoining);
        e.setSalary(salary);
        DAO.addEmpolyee(e);
        return e;
    }
    public  Empolyee deleteById(int id){
        Empolyee em =   DAO.getEmpolyee().stream().filter(e->
                e.getId()==id
        ).findFirst().orElse(null);
        if(em != null) DAO.removeEmpolyee(em);
        return em;
    };

    public  Empolyee updateEmpolyee(Empolyee empolyee){
        int id = empolyee.getId();
        Empolyee em =   DAO.getEmpolyee().stream().filter(e->
                e.getId()==id
        ).findFirst().orElse(null);
        if(em != null){
            if(empolyee.getName()!=null) em.setName(empolyee.getName());
            if(empolyee.getDesignation()!=null)em.setDesignation(empolyee.getDesignation());
            if(empolyee.getGender()!=null) em.setGender(empolyee.getGender());
            if(empolyee.getYearOfJoining()!=null) em.setYearOfJoining(empolyee.getYearOfJoining());
            if(empolyee.getSalary()!=null) em.setSalary(empolyee.getSalary());
        }
        return em;
    }

    public  Empolyee viewById(int id){
       return  DAO.getEmpolyee().stream().filter(e->
             e.getId()==id
        ).findFirst().orElse(null);
    };


    public  List<Empolyee> viewByName(String name,boolean ascending){
        if(ascending){
            return DAO.getEmpolyee().stream().filter(e->e.getName().equals(name)).sorted(
                    (e1,e2)-> {
                        return e1.getSalary().compareTo(e2.getSalary());
                    }
            ).collect(Collectors.toList());
        }
        return DAO.getEmpolyee().stream().filter(e->e.getName().equals(name)).sorted((e1,e2)->{
            return e2.getSalary().compareTo(e1.getSalary());
        }).collect(Collectors.toList());
    };

    public  List<Empolyee> viewALLBySalary(Double salary, boolean ascending){
        if(ascending){
            return DAO.getEmpolyee().stream().filter(e-> e.getSalary().equals(salary)).sorted((e1,e2)->{
                return e1.getName().compareTo(e2.getName());
            }).collect(Collectors.toList());
        }
        return DAO.getEmpolyee().stream().filter(e->e.getSalary().equals(salary)).sorted((e1,e2)->{
            return e2.getName().compareTo(e1.getName());
        }).collect(Collectors.toList());
    };

    public  List<Empolyee> viewByDesignation(String designation,boolean ascending){
        if(ascending){
            return DAO.getEmpolyee().stream().filter(e->e.getDesignation().equals(designation)).sorted(
                    (e1,e2)-> {
                        return e1.getSalary().compareTo(e2.getSalary());
                    }
            ).collect(Collectors.toList());
        }
        return DAO.getEmpolyee().stream().filter(e->e.getName().equals(designation)).sorted((e1,e2)->{
            return e2.getSalary().compareTo(e1.getSalary());
        }).collect(Collectors.toList());
    };

}
