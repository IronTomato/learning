package mybatis;

public class City {

    private Integer id;
    private String name;
    private String countryCode;
    private String district;
    private Integer population;
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }
    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }
    /**
     * @return the population
     */
    public Integer getPopulation() {
        return population;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }
    /**
     * @param population the population to set
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district
                + ", population=" + population + "]";
    }
    
    
}
