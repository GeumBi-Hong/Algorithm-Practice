package programmers;

    class 최소직사각형 {
        public int solution(int[][] sizes) {

            int maxHeight = 0 ;
            int maxWidth = 0;
            //가로를 긴 경우로 배치
            for(int i = 0 ; i < sizes.length;i++){
                if(sizes[i][0] <sizes[i][1]){
                    int tmp = sizes[i][0];
                    sizes[i][0]=sizes[i][1];
                    sizes[i][1]=tmp;
                }

                //가로로 제일 긴 길이와 세로로 제일 긴 것을 곱한게 정답
                //그 둘을 곱한 값이 지갑의 최소 크기이다.
                maxWidth = Math.max(maxWidth , sizes[i][0]);
                maxHeight = Math.max (maxHeight ,sizes[i][1]);
            }


            return maxWidth*maxHeight;


        }
    }

