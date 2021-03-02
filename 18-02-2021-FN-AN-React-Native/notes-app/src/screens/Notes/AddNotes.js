import React, {useState,useEffect} from "react";
import { View, Text, TextInput, StyleSheet, TouchableOpacity } from "react-native";
import AsyncStorage from '@react-native-async-storage/async-storage';
import {LinearGradient} from 'expo-linear-gradient';

const AddNotes = (props) => {

    const [uname, setUname] = useState('');
    const [title, setTitle] = useState('');
    const [Description, setDescription] = useState('');

    useEffect(() => {
        loadData();
    });

    const loadData = async () => {
        setUname(await AsyncStorage.getItem("userName"));
    }

    const addNote = async ()=> {

        let myNotes = JSON.parse(await AsyncStorage.getItem(uname));
        const newNote = {
            title,
            Description
        }
        if(myNotes == null)
        {
            myNotes=[];
        }
        myNotes.push(newNote);
        await AsyncStorage.setItem(uname, JSON.stringify(myNotes));
        props.navigation.navigate('Home');
    };


    return (
        <View style={styles.container}>
            <LinearGradient
                colors={['rgba(255,78,0,0.8)', 'transparent']}
                style={styles.background}>

            <Text style={{textAlign:'center', fontSize: 25,marginVertical: 30}}> New Note </Text>        

            <TextInput
                style = {styles.Input}
                placeholder="Title"
                value={title}
                onChangeText={val => setTitle(val)}
            />

            <TextInput
                style = {styles.InputDescription}
                placeholder="Description"
                multiline={true}
	            numberOfLines={5}
                value={Description}
                onChangeText={val => setDescription(val)}
            />

            <TouchableOpacity onPress={addNote} style={styles.add}>
                <Text style={{padding: 5, textAlign: 'center', color: 'white'}}>Add</Text>
            </TouchableOpacity>

            </LinearGradient>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex:1,
        backgroundColor: "orange"
    },
    background: {
        flex: 1
    },
    Input: {
        marginHorizontal: 50,
        marginTop: 30,
        borderWidth: 2,
        borderColor: 'black',
        padding: 6
    },
    InputDescription: {
        marginHorizontal: 50,
        marginTop: 30,
        borderWidth: 2,
        borderColor: 'black',
        padding: 6,
        minHeight: 80
    },
    add: { 
        marginTop: 30,
        marginHorizontal: 50,
        backgroundColor: 'black', 
        height: 30,
    }

});

export default AddNotes;