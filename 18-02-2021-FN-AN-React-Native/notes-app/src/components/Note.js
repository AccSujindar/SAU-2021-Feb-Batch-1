import React from "react";
import { View, Text, StyleSheet, TouchableOpacity } from "react-native";
import AsyncStorage from '@react-native-async-storage/async-storage';
const Note = (props) => {

    const deleteItem = async (idx) => {
        let uname =   await AsyncStorage.getItem("userName");
        let myNotes = JSON.parse(await AsyncStorage.getItem(uname));
        myNotes.splice(idx,1);
        await AsyncStorage.setItem(uname, JSON.stringify(myNotes));
        props.updateNotes(myNotes);
    }

    return <View style={styles.note}>
        <Text style={styles.Title}>{props.note.title}</Text>
        <Text style={styles.Description}>{props.note.Description}</Text>
        <TouchableOpacity onPress={()=>{deleteItem(props.index)}} style={styles.delete}>
            <Text style={{padding: 5, textAlign: 'center', color: 'white'}}>Delete</Text>
        </TouchableOpacity>
    </View>

}

const styles = StyleSheet.create({
    note: {
        marginHorizontal: 30,
        marginVertical: 20,
        minHeight: 50,
        alignItems: 'center',
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 2,
        },
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        elevation: 6,
        backgroundColor: 'rgba(255, 127, 80,1)'
    },
    Title: {
        padding: 10,
        fontWeight: 'bold',
        fontSize: 30,

    },
    Description: {
        fontStyle: 'italic',
        padding: 30,
        alignSelf: 'flex-start'
    },
    delete: {
        width: 50, 
        backgroundColor: 'red', 
        height: 30,
        alignSelf: 'flex-end',
        marginRight: 30,
        marginBottom: 10
    }
});

export default Note;