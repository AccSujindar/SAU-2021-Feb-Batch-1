import React, {useState,useEffect} from "react";
import { View, Text, TextInput, StyleSheet, TouchableOpacity } from "react-native";
import AsyncStorage from '@react-native-async-storage/async-storage';
import {LinearGradient} from 'expo-linear-gradient';
import { useIsFocused } from "@react-navigation/native";
const Login = (props) => {

    const [uname, setUname] = useState('');

    const isFocused = useIsFocused();
    useEffect(() => {
        setUname('');
    },[isFocused]);

    const login = async () => {
        if(uname==='')
        {
            return;
        }
        await AsyncStorage.setItem('userName',uname);
        props.navigation.navigate("Home");
    }
  return (
    <View style={styles.container}>
        <LinearGradient
        colors={['rgba(255,78,0,0.8)', 'transparent']}
        style={styles.background}
        />
        <Text style={styles.header}>Welcome !</Text>
        <View style = {styles.Login}>
            <TextInput
                style = {styles.Input}
                placeholder="username"
                value={uname}
                onChangeText={val => setUname(val)}
            />
            <TouchableOpacity onPress={login} style={{ marginHorizontal: 50, marginTop: 20, backgroundColor: 'black', height: 30}}>
                <Text style={{padding: 5, textAlign: 'center', color: 'white'}}>Login</Text>
            </TouchableOpacity>
        </View>
    </View>
  );
};

const styles = StyleSheet.create({
    header: {
        fontSize: 30,
        marginBottom: 10,
        textAlign: 'center',
        
    },
    container: {
        justifyContent: 'center',
        flex:1,
        backgroundColor: "orange"
    },
    background: {
        position: 'absolute',
        left: 0,
        right: 0,
        top: 0,
        height: 300
    },
    Login: {
        marginHorizontal: 30,
        height: 200,
        justifyContent: 'center',
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 2,
        },
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        elevation: 6,
        backgroundColor: "white"
    },
    Input: {
        marginHorizontal: 50,
        borderWidth: 2,
        borderColor: 'black',
        padding: 6
    }
});

export default Login;