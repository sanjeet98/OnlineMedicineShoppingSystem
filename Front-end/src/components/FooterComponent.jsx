/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import React, { Component } from 'react';

class FooterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            payments: []
        }
    }
    render() {
        return (
            <div>
                <footer className="footer">
                    <span className="text-muted"> All Rights Reserved 2021 </span>
                </footer>
            </div>
        );
    }
}

export default FooterComponent;