package defaultPack;
import java.util.Arrays;
import java.util.Random;
public class BpDeep{
    public double[][] layer;//神经网络各层节点
    public double[][] layerErr;//神经网络各节点误差
    public double[][][] layer_weight;//各层节点权重
    public double[][][] layer_weight_delta;//各层节点权重动量
    public double mobp;//动量系数
    public double rate;//学习系数

    public BpDeep(int[] layernum, double rate, double mobp){
        this.mobp = mobp;
        this.rate = rate;
//        System.out.println("***BpDeep*** 输入layernum（长度为网络总层数） rate mobp");
        layer = new double[layernum.length][];
//        System.out.println("***BpDeep*** 初始化二维数组layer各层节点，只定义了layer第一维长度："+layernum.length);
        layerErr = new double[layernum.length][];
//        System.out.println("***BpDeep*** 初始化二维数组layerErr各节点误差,和layer一样，只第一维");
        layer_weight = new double[layernum.length][][];
//        System.out.println("***BpDeep*** 初始化三维数组layer_weight,和layer一样，只第一维");
        layer_weight_delta = new double[layernum.length][][];
        Random random = new Random();
//        System.out.println("***BpDeep*** 开始前向计算 遍历每一层：");
        for(int l=0;l<layernum.length;l++){
//        	System.out.println("             第第 "+(l+1)+" 层：");
            layer[l]=new double[layernum[l]];
//            System.out.println("             定义layer["+(l+1)+"]第二维长度(通过layernum[l])："+layernum[l]);
            layerErr[l]=new double[layernum[l]];
//            System.out.println("             定义layer["+(l+1)+"]第二维长度(通过layernum[l])："+layernum[l]);
            if(l+1<layernum.length){
//            	System.out.println("             判断当前层不是最后一层时(通过l+1<layernum.length)：");
                layer_weight[l]=new double[layernum[l]+1][layernum[l+1]];
//                System.out.println("             定义layer_weight["+l+"]的后两维长度(通过layernum[(l+1)]+1][layernum[l+1])："+(layernum[l]+1)+"  "+(layernum[l+1]));
                layer_weight_delta[l]=new double[layernum[l]+1][layernum[l+1]];
//                System.out.println("             定义layer_delta["+l+"]的后两维长度(通过layernum[(l+1)]+1][layernum[l+1])："+(layernum[l]+1)+"  "+(layernum[l+1]));
//                System.out.println("             第第 "+(l+1)+" 层下开始遍历节点");
                for(int j=0;j<layernum[l]+1;j++){
//                	System.out.println("             第 "+(l+1)+" 层 第"+(j+1)+"个节点");
                    for(int i=0;i<layernum[l+1];i++){
                        layer_weight[l][j][i]=random.nextDouble();//随机初始化权重
//                        System.out.println("             layer_weight["+(l+1)+"] ["+(j+1)+"] ["+(i+1)+"]");
                     }
                }
            }   
        }
//        System.out.println("             layer_weight:"+Arrays.deepToString(layer_weight));
    }
    //逐层向前计算输出
    public double[] computeOut(double[] in){
//    	System.out.println("computOut");
        for(int l=1;l<layer.length;l++){
//        	System.out.println("   第"+(l+1)+"层：");
            for(int j=0;j<layer[l].length;j++){
//            	System.out.println("         第"+(j+1)+"个节点：");
                double z=layer_weight[l-1][layer[l-1].length][j];
//                System.out.println("         计算Z值(初始化Z) layer_weight["+l+"][layer["+l+"].length]["+(j+1)+"]");
                for(int i=0;i<layer[l-1].length;i++){
//                	System.out.println("            第"+(i+1)+"个节点(上一层)");
                    layer[l-1][i]=l==1?in[i]:layer[l-1][i];
//                    System.out.println("            计算layer["+l+"]["+(i+1)+"]:"+layer[l-1][i]+"(第二层为1，其它层层为本身)");
//                    System.out.println("**computeOut**:layer["+(l-1)+"]["+i+"]"+layer[l-1][i]);
                    z+=layer_weight[l-1][i][j]*layer[l-1][i];
//                    System.out.println("            计算z=z+"+"layer_weight["+l+"]["+(i+1)+"]["+(j+1)+"]*layer["+l+"]["+(i+1)+"]");
//                    System.out.println("**computeOut** z:"+z);
                }
                layer[l][j]=1/(1+Math.exp(-z));
//                System.out.println("         计算layer["+(l+1)+"]["+(j+1)+"]:"+layer[l][j]+"利用Z值");
            }
        }
//        System.out.println("返回值："+Arrays.toString(layer[layer.length-1]));
        return layer[layer.length-1];
    }
    //逐层反向计算误差并修改权重
    public void updateWeight(double[] tar){
    	System.out.println("updateWeight");
//    	System.out.println("layer"+Arrays.deepToString(layer));
        int l=layer.length-1;
//        System.out.println("*updateWeight* l:"+l);
        for(int j=0;j<layerErr[l].length;j++){//可将layerErr变为layer 只是为了求最后一层的节点个数
        	System.out.println("   第"+(layerErr[l].length+1)+"层(最后一层)"+(j+1)+"个节点(计算误差)");
            layerErr[l][j]=layer[l][j]*(1-layer[l][j])*(tar[j]-layer[l][j]);
            System.out.println("   计算layerErr["+(l+1)+"]["+(j+1)+"]=layer["+(l+1)+"]["+(j+1)+"]*(1-layer["+(l+1)+"]["+(j+1)+"])*(tar["+(j+1)+"]-layer["+(l+1)+"]["+(j+1)+"])");
        }

        while(l-->0){
        	System.out.println("   第"+(l+1)+"层");
            for(int j=0;j<layerErr[l].length;j++){
            	System.out.println("      第"+(j+1)+"个节点");
                double z = 0.0;
                System.out.println("      初始化z=0");
                for(int i=0;i<layerErr[l+1].length;i++){
                	System.out.println("         第"+(i+1)+"个节点(遍历下一层节点)");
                    z=z+l>0?layerErr[l+1][i]*layer_weight[l][j][i]:0;
                    System.out.println("         计算Z=layerErr["+(l+2)+"]["+(i+1)+"]*layer_weight["+(l+1)+"]["+(j+1)+"]["+(i+1)+"] 第一层时Z=0 Z:"+z);
                    layer_weight_delta[l][j][i]= mobp*layer_weight_delta[l][j][i]+rate*layerErr[l+1][i]*layer[l][j];//隐含层动量调整
                    System.out.println("         计算(隐含层动量调整)layer_weight_delta["+(l+1)+"]["+(j+1)+"]["+(i+1)+"]= mobp*layer_weight_delta["+(l+1)+"]["+(j+1)+"]["+(i+1)+"]+rate*layerErr["+(l+2)+"]["+(i+1)+"]*layer["+(l+1)+"]["+(j+1)+"]");
                    layer_weight[l][j][i]+=layer_weight_delta[l][j][i];//隐含层权重调整
                    System.out.println("         计算(隐含层权重调整)layer_weight["+(l+1)+"]["+(j+1)+"]["+(i+1)+"]+=layer_weight_delta["+(l+1)+"]["+(j+1)+"]["+(i+1)+"]");
                    if(j==layerErr[l].length-1){
                        layer_weight_delta[l][j+1][i]= mobp*layer_weight_delta[l][j+1][i]+rate*layerErr[l+1][i];//截距动量调整
                        layer_weight[l][j+1][i]+=layer_weight_delta[l][j+1][i];//截距权重调整
                        System.out.println("         计算偏置(截距权重调整 通过layerErr["+(l+1)+"].length-1判断)");
                    	System.out.println("         计算(截距动量调整)layer_weight_delta["+(l+1)+"]["+(j+2)+"]["+(i+1)+"]= mobp*layer_weight_delta["+(l+1)+"]["+(j+2)+"]["+(i+1)+"]+rate*layerErr["+(l+2)+"]["+(i+1)+"]");
                    	System.out.println("         计算(截距权重调整)layer_weight["+(l+1)+"]["+(j+2)+"]["+(i+1)+"]+=layer_weight_delta["+(l+1)+"]["+(j+2)+"]["+(i+1)+"]");
                    }
                }
                layerErr[l][j]=z*layer[l][j]*(1-layer[l][j]);//记录误差
                System.out.println("      计算(记录)layerErr["+(l+1)+"]["+(j+1)+"]=z*layer["+(l+1)+"]["+(j+1)+"]*(1-layer["+(l+1)+"]["+(j+1)+"]");
            }
        }
    }

    public void train(double[] in, double[] tar){
        double[] out = computeOut(in);
        updateWeight(tar);
    }
}