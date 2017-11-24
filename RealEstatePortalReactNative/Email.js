import {Button, TextInput, View} from "react-native";
import * as React from "react";
import Communications from 'react-native-communications';


export default class Email extends React.Component {
    static navigationOptions = {
        title: 'Mail',
    };

    constructor(props) {
        super(props);
        this.state = {message: ''}
    }

    render() {
        return <View>
            <TextInput
                style={{marginTop:50,marginBottom:50}}
                placeholder={"Message"}
                onChangeText={(message) => this.setState({message: message})}
            />
            <Button
                style={{height:50}}
                title={"Send"}
                onPress={() => {
                    Communications.email(['ardelean.patricia@gmail.com'], null, null, null, this.state.message);
                }}
            />
        </View>
    }
}