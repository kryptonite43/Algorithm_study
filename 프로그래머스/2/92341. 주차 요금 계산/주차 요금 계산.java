import java.util.*;
class Car {
    int inTime;
    int totalTime;
    int fee;
    
    public Car(int inTime, int totalTime, int fee) {
        this.inTime = inTime;
        this.totalTime = totalTime;
        this.fee = 0;     
    }
}
class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Car> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (String rcd: records) {
            String[] record = rcd.split(" ");
            
            int ctime = toMinute(record[0]);
            String carnum = record[1];
            
            if (record[2].equals("IN")) {
                if (!map.containsKey(carnum)) {
                    map.put(carnum, new Car(ctime, 0, 0));
                }
                else {
                    Car c =map.get(carnum);
                    c.inTime = ctime;
                }
                
            }
            else if (record[2].equals("OUT")) {
                Car c = map.get(carnum);
                c.totalTime += (ctime - c.inTime);
                c.inTime=-1;
                map.put(carnum, c);
            }
        }
        // 요금 계산
        for (Map.Entry<String, Car> entry: map.entrySet()) {
            Car car = entry.getValue();
            if (car.inTime != -1) {
                car.totalTime += (1439-car.inTime);
            }
            int use = car.totalTime;
            if (use<=fees[0]) {
                car.fee = fees[1];
            }
            else { // 기본요금초과
                car.fee = fees[1];
                use -= fees[0]; // 초과시간
                car.fee += fees[3] * (use/fees[2]);
                if (use%fees[2]!=0) {
                    car.fee += fees[3];
                }
            }
            map.put(entry.getKey(), car);
        }
        
        int[] answer = map.entrySet().stream()
            .sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
            .map(Map.Entry::getValue)
            .mapToInt(car->car.fee)
            .toArray();
        
        return answer;
        
    }
    
    public static int toMinute(String time) {
        String[] tm = time.split(":");
        int hr = Integer.parseInt(tm[0]);
        int mn = Integer.parseInt(tm[1]);
        return hr*60+mn;
    }
}

