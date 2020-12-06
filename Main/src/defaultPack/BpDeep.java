package defaultPack;
import java.util.Arrays;
import java.util.Random;
public class BpDeep{
    public double[][] layer;//���������ڵ�
    public double[][] layerErr;//��������ڵ����
    public double[][][] layer_weight;//����ڵ�Ȩ��
    public double[][][] layer_weight_delta;//����ڵ�Ȩ�ض���
    public double mobp;//����ϵ��
    public double rate;//ѧϰϵ��

    public BpDeep(int[] layernum, double rate, double mobp){
        this.mobp = mobp;
        this.rate = rate;
//        System.out.println("***BpDeep*** ����layernum������Ϊ�����ܲ����� rate mobp");
        layer = new double[layernum.length][];
//        System.out.println("***BpDeep*** ��ʼ����ά����layer����ڵ㣬ֻ������layer��һά���ȣ�"+layernum.length);
        layerErr = new double[layernum.length][];
//        System.out.println("***BpDeep*** ��ʼ����ά����layerErr���ڵ����,��layerһ����ֻ��һά");
        layer_weight = new double[layernum.length][][];
//        System.out.println("***BpDeep*** ��ʼ����ά����layer_weight,��layerһ����ֻ��һά");
        layer_weight_delta = new double[layernum.length][][];
        Random random = new Random();
//        System.out.println("***BpDeep*** ��ʼǰ����� ����ÿһ�㣺");
        for(int l=0;l<layernum.length;l++){
//        	System.out.println("             �ڵ� "+(l+1)+" �㣺");
            layer[l]=new double[layernum[l]];
//            System.out.println("             ����layer["+(l+1)+"]�ڶ�ά����(ͨ��layernum[l])��"+layernum[l]);
            layerErr[l]=new double[layernum[l]];
//            System.out.println("             ����layer["+(l+1)+"]�ڶ�ά����(ͨ��layernum[l])��"+layernum[l]);
            if(l+1<layernum.length){
//            	System.out.println("             �жϵ�ǰ�㲻�����һ��ʱ(ͨ��l+1<layernum.length)��");
                layer_weight[l]=new double[layernum[l]+1][layernum[l+1]];
//                System.out.println("             ����layer_weight["+l+"]�ĺ���ά����(ͨ��layernum[(l+1)]+1][layernum[l+1])��"+(layernum[l]+1)+"  "+(layernum[l+1]));
                layer_weight_delta[l]=new double[layernum[l]+1][layernum[l+1]];
//                System.out.println("             ����layer_delta["+l+"]�ĺ���ά����(ͨ��layernum[(l+1)]+1][layernum[l+1])��"+(layernum[l]+1)+"  "+(layernum[l+1]));
//                System.out.println("             �ڵ� "+(l+1)+" ���¿�ʼ�����ڵ�");
                for(int j=0;j<layernum[l]+1;j++){
//                	System.out.println("             �� "+(l+1)+" �� ��"+(j+1)+"���ڵ�");
                    for(int i=0;i<layernum[l+1];i++){
                        layer_weight[l][j][i]=random.nextDouble();//�����ʼ��Ȩ��
//                        System.out.println("             layer_weight["+(l+1)+"] ["+(j+1)+"] ["+(i+1)+"]");
                     }
                }
            }   
        }
//        System.out.println("             layer_weight:"+Arrays.deepToString(layer_weight));
    }
    //�����ǰ�������
    public double[] computeOut(double[] in){
//    	System.out.println("computOut");
        for(int l=1;l<layer.length;l++){
//        	System.out.println("   ��"+(l+1)+"�㣺");
            for(int j=0;j<layer[l].length;j++){
//            	System.out.println("         ��"+(j+1)+"���ڵ㣺");
                double z=layer_weight[l-1][layer[l-1].length][j];
//                System.out.println("         ����Zֵ(��ʼ��Z) layer_weight["+l+"][layer["+l+"].length]["+(j+1)+"]");
                for(int i=0;i<layer[l-1].length;i++){
//                	System.out.println("            ��"+(i+1)+"���ڵ�(��һ��)");
                    layer[l-1][i]=l==1?in[i]:layer[l-1][i];
//                    System.out.println("            ����layer["+l+"]["+(i+1)+"]:"+layer[l-1][i]+"(�ڶ���Ϊ1���������Ϊ����)");
//                    System.out.println("**computeOut**:layer["+(l-1)+"]["+i+"]"+layer[l-1][i]);
                    z+=layer_weight[l-1][i][j]*layer[l-1][i];
//                    System.out.println("            ����z=z+"+"layer_weight["+l+"]["+(i+1)+"]["+(j+1)+"]*layer["+l+"]["+(i+1)+"]");
//                    System.out.println("**computeOut** z:"+z);
                }
                layer[l][j]=1/(1+Math.exp(-z));
//                System.out.println("         ����layer["+(l+1)+"]["+(j+1)+"]:"+layer[l][j]+"����Zֵ");
            }
        }
//        System.out.println("����ֵ��"+Arrays.toString(layer[layer.length-1]));
        return layer[layer.length-1];
    }
    //��㷴��������޸�Ȩ��
    public void updateWeight(double[] tar){
    	System.out.println("updateWeight");
//    	System.out.println("layer"+Arrays.deepToString(layer));
        int l=layer.length-1;
//        System.out.println("*updateWeight* l:"+l);
        for(int j=0;j<layerErr[l].length;j++){//�ɽ�layerErr��Ϊlayer ֻ��Ϊ�������һ��Ľڵ����
        	System.out.println("   ��"+(layerErr[l].length+1)+"��(���һ��)"+(j+1)+"���ڵ�(�������)");
            layerErr[l][j]=layer[l][j]*(1-layer[l][j])*(tar[j]-layer[l][j]);
            System.out.println("   ����layerErr["+(l+1)+"]["+(j+1)+"]=layer["+(l+1)+"]["+(j+1)+"]*(1-layer["+(l+1)+"]["+(j+1)+"])*(tar["+(j+1)+"]-layer["+(l+1)+"]["+(j+1)+"])");
        }

        while(l-->0){
        	System.out.println("   ��"+(l+1)+"��");
            for(int j=0;j<layerErr[l].length;j++){
            	System.out.println("      ��"+(j+1)+"���ڵ�");
                double z = 0.0;
                System.out.println("      ��ʼ��z=0");
                for(int i=0;i<layerErr[l+1].length;i++){
                	System.out.println("         ��"+(i+1)+"���ڵ�(������һ��ڵ�)");
                    z=z+l>0?layerErr[l+1][i]*layer_weight[l][j][i]:0;
                    System.out.println("         ����Z=layerErr["+(l+2)+"]["+(i+1)+"]*layer_weight["+(l+1)+"]["+(j+1)+"]["+(i+1)+"] ��һ��ʱZ=0 Z:"+z);
                    layer_weight_delta[l][j][i]= mobp*layer_weight_delta[l][j][i]+rate*layerErr[l+1][i]*layer[l][j];//�����㶯������
                    System.out.println("         ����(�����㶯������)layer_weight_delta["+(l+1)+"]["+(j+1)+"]["+(i+1)+"]= mobp*layer_weight_delta["+(l+1)+"]["+(j+1)+"]["+(i+1)+"]+rate*layerErr["+(l+2)+"]["+(i+1)+"]*layer["+(l+1)+"]["+(j+1)+"]");
                    layer_weight[l][j][i]+=layer_weight_delta[l][j][i];//������Ȩ�ص���
                    System.out.println("         ����(������Ȩ�ص���)layer_weight["+(l+1)+"]["+(j+1)+"]["+(i+1)+"]+=layer_weight_delta["+(l+1)+"]["+(j+1)+"]["+(i+1)+"]");
                    if(j==layerErr[l].length-1){
                        layer_weight_delta[l][j+1][i]= mobp*layer_weight_delta[l][j+1][i]+rate*layerErr[l+1][i];//�ؾද������
                        layer_weight[l][j+1][i]+=layer_weight_delta[l][j+1][i];//�ؾ�Ȩ�ص���
                        System.out.println("         ����ƫ��(�ؾ�Ȩ�ص��� ͨ��layerErr["+(l+1)+"].length-1�ж�)");
                    	System.out.println("         ����(�ؾද������)layer_weight_delta["+(l+1)+"]["+(j+2)+"]["+(i+1)+"]= mobp*layer_weight_delta["+(l+1)+"]["+(j+2)+"]["+(i+1)+"]+rate*layerErr["+(l+2)+"]["+(i+1)+"]");
                    	System.out.println("         ����(�ؾ�Ȩ�ص���)layer_weight["+(l+1)+"]["+(j+2)+"]["+(i+1)+"]+=layer_weight_delta["+(l+1)+"]["+(j+2)+"]["+(i+1)+"]");
                    }
                }
                layerErr[l][j]=z*layer[l][j]*(1-layer[l][j]);//��¼���
                System.out.println("      ����(��¼)layerErr["+(l+1)+"]["+(j+1)+"]=z*layer["+(l+1)+"]["+(j+1)+"]*(1-layer["+(l+1)+"]["+(j+1)+"]");
            }
        }
    }

    public void train(double[] in, double[] tar){
        double[] out = computeOut(in);
        updateWeight(tar);
    }
}