package alex.pol.util.restServerInteraction;


import alex.pol.util.ClassNameUtil;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.cache.HttpCacheContext;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.CachingHttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Entity;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;





@RestController
public class ServerInteractionController {


    private final CacheConfig cacheConfig = CacheConfig.custom()
            .setMaxCacheEntries(1000)
            .setMaxObjectSize(8192)
            .build();
    private final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(30000)
            .setSocketTimeout(30000)
            .build();
    private final CloseableHttpClient cachingClient = CachingHttpClients.custom()
            .setCacheConfig(cacheConfig)
            .setDefaultRequestConfig(requestConfig)
            .build();
    private final HttpCacheContext context = HttpCacheContext.create();


    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    //private static final String restUrl = "http://localhost:8080";



    @RequestMapping(value = "/hellorest")
    @ResponseBody
    public String socketConnectionWithRest(){
        //to make this method work, you have to add the following code to REST server main method:
        /*try{
			ServerSocket ss = new ServerSocket(8082);
			Socket socket = ss.accept();
			InputStream sin = socket.getInputStream();
			OutputStream sout = socket.getOutputStream();
			DataInputStream in = new DataInputStream(sin);
			DataOutputStream out = new DataOutputStream(sout);

			char[] restChars = TokenGenerator.generateRandomCharArray(32);
			byte[] restBytes =new String(restChars).getBytes();
			while(true){
				int length = in.readInt();
				if(length>0) {
					byte[] bytesFromClient = new byte[length];
					in.readFully(bytesFromClient, 0, bytesFromClient.length);
					if (Arrays.equals(bytesFromClient, restBytes)) {
						out.writeUTF("Hello from rest, Client");
					}else{
						out.writeUTF("Sorry, the tokens do not coinside...");
					}
				}
				out.flush();
			}
		}catch(Exception x){
			x.printStackTrace();
		}*/
        try {
            InetAddress ipAddress = InetAddress.getByName( "127.0.0.1");
            Socket socket = new Socket(ipAddress, 8082);
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            char[] line = TokenGenerator.generateRandomCharArray(32);
            byte[] bytes =new String(line).getBytes();
            out.writeInt(bytes.length);
            out.write(bytes);
            out.flush();


            String responseFromServer=in.readUTF();
            return responseFromServer;
        }catch(Exception x){
            x.printStackTrace();
        }
        return null;
    }


    @RequestMapping("try")
    public ModelAndView web6(){
        return new ModelAndView("test");
    }

    @RequestMapping(value = "/web5", method = RequestMethod.POST)
    public String web5() throws IOException {
        String url = "http://localhost:8080/clientTokenCheck";
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> postParameters= new ArrayList<>();
        String clientToken = new String(TokenGenerator.generateRandomCharArray(32));
        postParameters.add(new BasicNameValuePair("token", clientToken));
        httpPost.setEntity(new UrlEncodedFormEntity(postParameters));
        try (CloseableHttpResponse response = cachingClient.execute(httpPost, context)){
            HttpEntity entity;
            if (response.getStatusLine().getStatusCode() == 200) {
                entity = response.getEntity();
                if (entity != null && entity.getContentLength() != -1) {
                    String body = EntityUtils.toString(entity);
                    return body;//ResponseEntity.ok().body(body);
                }
            }
        }
        return null;
    }

}

