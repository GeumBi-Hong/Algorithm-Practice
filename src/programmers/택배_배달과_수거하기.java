package programmers;

import java.util.Stack;

class 택배_배달과_수거하기 {

    static class House {

        private int distance;
        private int deliveryCount;
        private int pickupCount;

        public House(int distance, int deliveryCount, int pickupCount){
            this.distance = distance;
            this.deliveryCount = deliveryCount;
            this.pickupCount = pickupCount;
        }

    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        //[1]배달 스택, 수거 스택을 생성한다.
        Stack<House> deliveryStack = new Stack<>();
        Stack<House> pickupStack = new Stack<>();

        int size = deliveries.length;


        //[2]배달할 물건이 있는 경우만 배달스택에 , 수거할 물품이 있는 집만 수거 스택
        for(int d = 0; d < size; d++){

            if(deliveries[d] != 0){
                deliveryStack.add(new House(d + 1,deliveries[d],0));
            }

            if(pickups[d] != 0){
                pickupStack.add(new House(d + 1,0,pickups[d]));
            }

        }
        long minTotalDistance = 0;

        while(true){

            //1. 둘 중 가장 먼 거리 부터 이동 해야함
            if(deliveryStack.isEmpty() && pickupStack.isEmpty()){
                break;
            }
            int haveToMove = 0;

            if(deliveryStack.isEmpty() && !pickupStack.isEmpty()){
                haveToMove = pickupStack.peek().distance;
            }else if(pickupStack.isEmpty() && !deliveryStack.isEmpty()){
                haveToMove = deliveryStack.peek().distance;
            }else{
                haveToMove = Math.max(deliveryStack.peek().distance ,pickupStack.peek().distance);
            }

            minTotalDistance += haveToMove * 2;

            int canDelivery = cap;

            while (canDelivery != 0){

                if(deliveryStack.isEmpty())break;
                House house = deliveryStack.pop();

                //배달 해야되는 개수 보다 집이 가지고 있는게 작을 경우
                if(house.deliveryCount <= canDelivery){
                    canDelivery -= house.deliveryCount;
                }else{
                    house.deliveryCount -= canDelivery;
                    canDelivery = 0;
                    deliveryStack.add(house);

                }

            }

            //그 다음 수거 배달은 다 했다는 가정하에
            int canPickup = cap;

            while (canPickup != 0 ){
                if(pickupStack.isEmpty()) break;
                House house = pickupStack.pop();

                //배달 해야되는 개수 보다 집이 가지고 있는게 작을 경우
                if(house.pickupCount <= canPickup){
                    canPickup -= house.pickupCount;
                }else{
                    house.pickupCount -= canPickup;
                    canPickup = 0;
                    pickupStack.add(house);
                }
            }
        }

        return minTotalDistance;
    }
}