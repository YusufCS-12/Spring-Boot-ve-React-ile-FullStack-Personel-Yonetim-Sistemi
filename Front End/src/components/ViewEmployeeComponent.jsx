import React, { Component } from 'react';
import PropTypes from 'prop-types';
import EmployeeService from '../services/EmployeeService';

class ViewEmployeeComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {

            id: this.props.match.params.id,
            employee: {}
        }

    }
    componentDidMount() {

        EmployeeService.getEmployeeById(this.state.id).then(res=>{
            this.setState({employee:res.data});
        });
    }

   

    render() {
        return (
            <div>
                <div className = "carrd col-md-6 offset-md-3">

                    <h3 className = "text-center"> Personel Bilgi Sayfası</h3>
                    <div className = "car-body" >
                        <div className = "row">
                            <label> Personel Adı</label>
                            <div> {this.state.employee.firstName }</div>

                        </div>

                        <div className = "row">
                            <label> Personel Soyadı</label>
                            <div> {this.state.employee.lastName }</div>
                            
                        </div>

                        <div className = "row">
                            <label> Personel Email</label>
                            <div> {this.state.employee.emailId }</div>
                            
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}


export default ViewEmployeeComponent;