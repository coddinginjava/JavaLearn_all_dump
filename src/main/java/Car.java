public class Car {
    private Integer modelNo;
    private String modelName;

    public Car() {
    }

    public Car(String modelName, Integer modelNo) {
        this.modelName = modelName;
        this.modelNo = modelNo;
    }

    public String getModelName() {
        return modelName;
    }

    public Integer getModelNo() {
        return modelNo;
    }

    @Override
    public boolean equals(Object object){
        if(object!=null){
            if(object instanceof  Car){
            Car car = (Car) object;
            return this.modelNo.equals(car.modelNo);
            }
        }
        return  false;
    }

}
