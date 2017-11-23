import React from 'react';
import {StyleSheet} from 'react-native';
import StackNavigator from "react-navigation/lib-rn/navigators/StackNavigator";
import PropertyList from "./PropertyList";
import PropertyDetails from "./PropertyDetails";
import Email from "./Email"



const MyNavigator = StackNavigator({
        List: {screen: PropertyList},
        Details: {screen: PropertyDetails},
        Mail: {screen: Email}
    });

export default class App extends React.Component {
    render() {
        return( <MyNavigator/>);
    }

}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
});