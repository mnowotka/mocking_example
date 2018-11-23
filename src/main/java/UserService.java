import net.dongliu.requests.Requests;

interface DataAccessObject{
    String getUserData(String username);
}

class InternetDataAccessObject implements DataAccessObject{

    private static final String GITHUB_API_ROOT = "api.gbvnvnbvithub.com";
    private static final String GITHUB_API_PROTOCOL = "https";

    private String getURLForMethodName(){
        return "users";
    }

    private String getURLForMethodName(String methodName){
        return String.format("%s://%s/%s/", GITHUB_API_PROTOCOL, GITHUB_API_ROOT, methodName);
    }

    private String getUserURL(String username){
        return getURLForMethodName(getURLForMethodName()) + username;
    }

    private String fetchDataFromURL(String url){
        return Requests.get(url).send().readToText();
    }

    public String getUserData(String username){
        String url = getUserURL(username);
        return fetchDataFromURL(url);
    }
}

class UserService {

    private DataAccessObject dao;

    UserService(DataAccessObject dao){
        this.dao = dao;
    }

    String greeting(){
        return "Hello, World!";
    }

    String getUserData(String username){
        return dao.getUserData(username);
    }

}
