/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import axios from 'axios';

const CART_API_BASE_URL = "http://localhost:8080/api/v1/confirmcart";

class CartService {

    getCart() {
        return axios.get(CART_API_BASE_URL);
    }


    getCartById(id) {
        return axios.get(CART_API_BASE_URL + '/' + id);
    }


}

export default new CartService()