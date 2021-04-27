/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import './App.css';
import CreatePaymentComponent from './components/CreatePaymentComponent';
import ViewPaymentComponent from './components/ViewPaymentComponent';
import ListPaymentComponent from './components/ListPaymentComponent';
import UpdatePaymentComponent from './components/UpdatePaymentComponent';
import SignUpComponent from './components/SignUpComponent'
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom'
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListMedicineComponent from './components/ListMedicineComponent'; 
import ListUserComponent from './components/ListUserComponent'; 
import CreateMedicineComponent from './components/CreateMedicineComponent';
import CreateUserComponent from './components/CreateUserComponent';
import UpdateMedicineComponent from './components/UpdateMedicineComponent';
import UpdateUserComponent from './components/UpdateUserComponent';
import ViewMedicineComponent from './components/ViewMedicineComponent';
import ViewUserComponent from './components/ViewUserComponent';
import 'bootstrap/dist/css/bootstrap.min.css'
import ListCartComponent from './components/ListCartComponent';
import SignInComponent from './components/SignInComponent';
import 'bootstrap/dist/css/bootstrap.min.css'

function App() {
  return (
    <div>
      <Router>
      <HeaderComponent/>
      <div className="container">
        <Switch> 
          <Route path="/" exact component={ListMedicineComponent}></Route>
          <Route path="/medicines"  component={ListMedicineComponent}></Route>
          <Route path="/add-medicines/:id"  component={CreateMedicineComponent}></Route>
          <Route path = "/view-medicine/:id" component = {ViewMedicineComponent}></Route>
          <Route path="/update-medicine/:id"  component={UpdateMedicineComponent}></Route>

         {/* <Route path = "/" exact component = {ListPaymentComponent}></Route> */}
         <Route path = "/payments" component = {ListPaymentComponent}></Route>
         <Route path = "/add-payment/:paymentId" component = {CreatePaymentComponent}></Route>
         <Route path = "/view-payment/:paymentId" component = {ViewPaymentComponent}></Route>
         {/* <Route path = "/update-payment" component = {UpdatePaymentComponent}></Route> */} 

         
          <Route path="/signin"  component={SignInComponent}></Route>
          <Route path="/signup"  component={SignUpComponent}></Route> 


          <Route path="/" exact component={ListUserComponent}></Route>
           <Route path="/users"  component={ListUserComponent}></Route>
          <Route path="/add-users/:id"  component={CreateUserComponent}></Route>
          <Route path = "/view-user/:id" component = {ViewUserComponent}></Route>
          <Route path="/update-user/:id"  component={UpdateUserComponent}></Route>

          <Route path="/confirmcart"  component={ListCartComponent}></Route>
          



      </Switch>
    </div>
    <FooterComponent/>
    </Router>
    </div>
  );
}

export default App;