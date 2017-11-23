import React from 'react';
import {Button, Text, TextInput, View} from 'react-native';

export default class DetailsScreen extends React.Component {
    static navigationOptions = {
        title: 'Details',
    };


    constructor(props) {
        super(props);
        this.state = {
            id: this.props.navigation.state.params.item.id,
            title: this.props.navigation.state.params.item.title,
            description: this.props.navigation.state.params.item.description,
        };
    }


    save(id, title, description) {
        const {navigation} = this.props;
        navigation.goBack();
        navigation.state.params.onSelect({id: id, title: title, description: description});
    }

    render() {
        return (
            <View>
                <Text>
                    Details of {this.props.navigation.state.params.item.id}
                </Text>
                <TextInput
                    style={{height: 40, borderColor: 'purple', borderWidth: 1}}
                    onChangeText={(text) => this.setState({title: text})}
                    value={this.state.title}
                />
                <TextInput
                    style={{height: 40, borderColor: 'purple', borderWidth: 1}}
                    onChangeText={(text) => this.setState({description: text})}
                    value={this.state.description}
                />

                <Button
                    style={{marginTop:20}}
                    title="Save"
                    onPress={() => this.save(this.state.id, this.state.title, this.state.description)}/>
            </View>
        );
    }
}