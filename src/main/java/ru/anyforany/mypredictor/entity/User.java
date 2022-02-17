package ru.anyforany.mypredictor.entity;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Entity
@Table(name = "t_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=11, message = "В 11-значном формате")
    private String username;

    @Size(min=5, message = "Не меньше 5 знаков")
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    private String balance;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getBalance()  {
        return balance;
    }

    public void setBalance(String clientPhoneNumber) throws UnsupportedEncodingException {
//        StringBuilder result = new StringBuilder();
//
//        Map<String,String> map = new ConcurrentHashMap<>();
//
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        try {
//            HttpPost httppost = new HttpPost("https://tirage.getmeback.ru/rest/base/v32/validator/get-users");
//
//            String key = "{\"api_key\":\"6885125aa4ad5a7179b1eb563b23b01d\",\"limit\":\"1000\"}";
//
//            StringEntity stringEntity = new StringEntity(key);
//
//            try {
//                httppost.setEntity(stringEntity);
//
//                CloseableHttpResponse response = httpclient.execute(httppost);
//                try {
//                    HttpEntity entity = response.getEntity();
//                    StatusLine sl = response.getStatusLine();
//                    System.out.println(sl.toString());
//
//                    if (entity != null) {
//                        String retSrc = EntityUtils.toString(entity);
//
//                        Object obj = new JSONParser().parse(retSrc);
//                        JSONObject jObj = (JSONObject) obj;
//                        JSONArray users = (JSONArray) jObj.get("users");
//                        Iterator iterator = users.iterator();
//                        while (iterator.hasNext()) {
//                            JSONObject user = (JSONObject) iterator.next();
//                            String phNumber = (String) user.get("phone");
//                            String balance = (String) user.get("balance");
//                            try {
//                                map.put(phNumber, balance);
//                            } catch (NullPointerException e) { /* e.printStackTrace(); */ }
//                        }
//                    }
//                } finally {
//                    response.close();
//                }
//            } catch (IOException | org.json.simple.parser.ParseException e) {
//                e.printStackTrace();
//            }
//        } finally {
//            try {
//                httpclient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        for(Map.Entry<String,String> entry : map.entrySet()){
//            if(entry.getKey().equals(clientPhoneNumber)) {             // входящий номер телефона
//                result.append(entry.getValue());
//            }
//        }
//        balance = result.toString();
    }
}