package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        int i = ((ip[0] & 0xFF) << 24) + ((ip[1] & 0xFF) << 16) + ((ip[2] & 0xFF) << 8) + (ip[3] & 0xFF);
        int k = ((mask[0] & 0xFF) << 24) + ((mask[1] & 0xFF) << 16) + ((mask[2] & 0xFF) << 8) + (mask[3] & 0xFF);
        int r =i & k;
        byte[] result = new byte[4];
        result[0] = (byte) (r >> 24);
        result[1] = (byte) (r >> 16);
        result[2] = (byte) (r >> 8);
        result[3] = (byte) (r /*>> 0*/);

        return result;}

    public static void print(byte[] bytes) {

        for (int i = 0; i <bytes.length ; i++) {
            System.out.print(String.format("%8s", Integer.toBinaryString(Byte.toUnsignedInt(bytes[i]))).replace(" ","0"));
            System.out.print(" ");

        }
        System.out.println();

    }
}
