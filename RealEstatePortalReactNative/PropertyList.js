import * as React from "react";
import {Button, ListView, Text, View} from "react-native";

export default class ListScreen extends React.Component {
    static navigationOptions = {
        title: 'List of properties',
    };

    propertyList = [
        {
            id: '1xyasd223',
            title: 'Nice apartment in the heart of the city',
            description: '1 kitchen, 2 bedrooms...'
        },
        {
            id: 'ase3ddxd4',
            title: 'Beautiful house at the countryside',
            description: '4 bedrooms, 1 garage..'
        },
        {
            id: 'aqde23xj9',
            title: 'Studio apartment on 50th Avenue',
            description: 'An apartment designed for very active people...'
        }
    ];


    constructor(props) {
        super(props);
        const ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
        this.state = {
            dataSource: ds.cloneWithRows(this.propertyList),
        };
    }

    renderItem(item) {
        const {navigate} = this.props.navigation;
        return (
            <View>
                <Text
                    style={{fontSize: 30}}>{item.title}</Text>
                <Button
                    title='Update'
                    onPress={() => navigate('Details', {item, onSelect: this.onSelect})}/>
            </View>
        );
    }

    onSelect = item => {
        let objIndex = this.propertyList.findIndex((obj => obj.id === item.id));
        if (objIndex >= 0) {
            this.propertyList[objIndex].title = item.title;
            this.propertyList[objIndex].description = item.description;
            const ds = new ListView.DataSource({rowHasChanged: (r1, r2) => r1 !== r2});
            this.setState({dataSource: ds.cloneWithRows(this.propertyList)});
        }
    };

    render() {
        return (
            <View>
                <Button
                    title={"Contact Us"}
                    onPress={() => this.props.navigation.navigate('Mail')}
                />

                <ListView
                    style={{marginTop: 50}}
                    dataSource={this.state.dataSource}
                    renderRow={(rowData) => this.renderItem(rowData)}
                />
            </View>
        );
    }
}