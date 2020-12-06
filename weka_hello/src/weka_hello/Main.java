package weka_hello;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;  
import weka.core.Instances;
import weka.core.converters.ArffSaver;  

public class Main{
	
	public static void main(String[] args){
		System.out.println("hello");
		House house = new House( 1, 2, 3, 4, 5, 6);
		ArrayList<House> list = new ArrayList<>();
		list.add(house);
		Instances instances = generatePopularInstance(list);
		String path = "d://haha.arff";
		generateArffFile(instances, path);
	}
	
	//创建Instances
	private static Instances generatePopularInstance(List<House> entities) {
        //set attributes
        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("houseSize"));
        attributes.add(new Attribute("lotSize"));
        attributes.add(new Attribute("bedrooms"));
        attributes.add(new Attribute("granite"));
        attributes.add(new Attribute("bathroom"));
        attributes.add(new Attribute("sellingPrice"));
        //set instances
        Instances instances = new Instances("instances_obj",attributes,0);
        instances.setClassIndex(instances.numAttributes() - 1);
        //add instance
        for (House house: entities) {
            Instance instance = new DenseInstance(attributes.size());
            instance.setValue(0,house.getHouseSize());
            instance.setValue(1,house.getLotSize());
            instance.setValue(2,house.getBedrooms());
            instance.setValue(3,house.getGranite());
            instance.setValue(4,house.getBathroom());
            instance.setValue(5,house.getSellingPrice());
            instances.add(instance);
        }
        return instances;
    }
	
	 /**
     * generate weka dataSource file
     * @param instances weka Instances
     * 保存Instances对象为arff文件
     */
    public static void generateArffFile(Instances instances, String path) {
        ArffSaver saver = new ArffSaver();
        saver.setInstances(instances);
        try {
            saver.setFile(new File(path));
            saver.writeBatch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

