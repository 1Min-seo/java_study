package coolsms;

import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class sms {
  public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
    String api_key = "NCS5AEE62BFXMTI8";
    String api_secret = "JC3ZZOMUS0EYNEWK5NXM78DCJMIECFTY";
    Message coolsms = new Message(api_key, api_secret);

    // 4 params(to, from, type, text) are mandatory. must be filled
    // HashMap<&,&>은 put()을 통해 인자로 key와 value를 받는다. 전달된 인자는 HashMap에 key-value 관계로 저장된다.
    // 삭제할 때는 remove()를 통해 전달된 key에 해당하는 데이터를 삭제한다. 삭제되면 value가 리턴
    HashMap<String, String> params = new HashMap<String, String>();
    String toNumber=sc.next();
    String fromNumber=sc.next();
    params.put("to", toNumber);	// 수신전화번호
    params.put("from", fromNumber);	// 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
    params.put("type", "SMS");
    params.put("text", "딴 짓 노노~");
    params.put("app_version", "test app 1.2"); // application name and version

    try {
      JSONObject obj = (JSONObject) coolsms.send(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
  }
}