import axios from "axios";

const baseUrl='http://localhost:8080/api/v1/users';
class UserService{
    saveUser(user){
        return axios.post(baseUrl,user);
    }
    getAlluser(){
        return axios.get(baseUrl);
    }
    deleteUser(id){
        return axios.delete(baseUrl+`/${id}`);
    }
    updateUser(id , user){
        return axios.put(baseUrl+`/${id}` , user);
    }
}
export default new UserService();