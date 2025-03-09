package org.example.model;


import jakarta.persistence.*;



@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "Code", nullable = false, length = 3)
    private String code;

    @Column(name = "Name", nullable = false, length = 52)
    private String name;

    @Column(name = "Continent", nullable = false, length = 50)
    private String continent;

    @Column(name = "Region", nullable = false, length = 26)
    private String region;

    @Column(name = "Surfacearea", nullable = false)
    private Double surfacearea;

    @Column(name = "Indepyear")
    private Short indepyear;

    @Column(name = "Population", nullable = false)
    private Integer population;

    @Column(name = "Lifeexpectancy")
    private Double lifeexpectancy;

    @Column(name = "GNP")
    private Double gnp;

    @Column(name = "GNPOld")
    private Double gnpOld;

    @Column(name = "Localname", nullable = false, length = 45)
    private String localname;

    @Column(name = "Government", nullable = false, length = 45)
    private String government;

    @Column(name = "Leader", length = 60)
    private String leader;

    @Column(name = "Capital")
    private Integer capital;

    @Column(name = "Code2", nullable = false, length = 2)
    private String code2;

    public Country() {
    }

    // 🔹 GETTEREK & SETTEREK HELYESEN

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }


    public Double getSurfacearea() { return surfacearea; }
    public void setSurfacearea(Double surfacearea) { this.surfacearea = surfacearea; }


    public Short getIndepyear() { return indepyear; }
    public void setIndepyear(Short indepyear) { this.indepyear = indepyear; }

    public Integer getPopulation() { return population; }
    public void setPopulation(Integer population) { this.population = population; }

    public Double getLifeexpectancy() { return lifeexpectancy; }
    public void setLifeexpectancy(Double lifeexpectancy) { this.lifeexpectancy = lifeexpectancy; }

    public Double getGnp() { return gnp; }
    public void setGnp(Double gnp) { this.gnp = gnp; }

    public Double getGnpOld() { return gnpOld; }
    public void setGnpOld(Double gnpOld) { this.gnpOld = gnpOld; }

    public String getLocalname() { return localname; }
    public void setLocalname(String localname) { this.localname = localname; }

    public String getGovernment() { return government; }
    public void setGovernment(String government) { this.government = government; }

    public String getLeader() { return leader; }
    public void setLeader(String leader) { this.leader = leader; }

    public Integer getCapital() { return capital; }
    public void setCapital(Integer capital) { this.capital = capital; }

    public String getCode2() { return code2; }
    public void setCode2(String code2) { this.code2 = code2; }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfacearea=" + surfacearea +
                ", indepyear=" + indepyear +
                ", population=" + population +
                ", lifeexpectancy=" + lifeexpectancy +
                ", gnp=" + gnp +
                ", gnpOld=" + gnpOld +
                ", localname='" + localname + '\'' +
                ", government='" + government + '\'' +
                ", leader='" + leader + '\'' +
                ", capital=" + capital +
                ", code2='" + code2 + '\'' +
                '}';
    }
}
