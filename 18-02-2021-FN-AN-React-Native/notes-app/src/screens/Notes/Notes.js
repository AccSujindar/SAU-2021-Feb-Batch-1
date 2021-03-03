import React, {useState, useEffect, Component} from "react";
import { View, Text, StyleSheet, TouchableOpacity, FlatList } from "react-native";
import AsyncStorage from '@react-native-async-storage/async-storage';
import {LinearGradient} from 'expo-linear-gradient';
import { useIsFocused } from "@react-navigation/native";
import Note from '../../components/Note';
const Notes = (props) => {

    const [uname,setUname] = useState('');
    const [myNotes,setMyNotes] = useState([]);
    const isFocused = useIsFocused();
    useEffect(() => {
        fetchData();
    },[isFocused]);

    const updateNotes = (allnotes) => {
        setMyNotes({allnotes});
    }
 
    const fetchData = async () => {
        try 
        {
            var userName = await AsyncStorage.getItem("userName");
            var allnotes  = [];
            allnotes = JSON.parse(await AsyncStorage.getItem(userName));
            setUname(userName);
            setMyNotes({allnotes});
        }
        catch (err) {
            console.log(err);
        }
    }


    return (
        <View style={styles.container}>
            <LinearGradient
                colors={['rgba(255,78,0,0.8)', 'transparent']}
                style={styles.background}>

                <View>
                    <LinearGradient
                        colors={['rgba(252,82,150,0.5)', 'transparent']}
                        style={styles.header}>
                        <Text style={styles.headerText}>Welcome {uname} !</Text>
                        <TouchableOpacity onPress={()=>props.navigation.navigate('AddNotes')} style={styles.add}>
                            <Text style={{padding: 5, textAlign: 'center', color: 'white'}}>Add</Text>
                        </TouchableOpacity>
                    </LinearGradient>
                </View>

                
                    {   myNotes.allnotes && myNotes.allnotes.length==0 ? <Text style={styles.empty}>No Notes Added</Text>:
                        <View>
                            <FlatList 
                                keyExtractor = {(item, index) => index.toString()}
                                data={myNotes.allnotes} 
                                renderItem={({item,index})=>{
                                    return <Note {...props} note={item} index={index} updateNotes={updateNotes}/>
                                }} 
                            />
                        </View>
                    }
                
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
    header: {
        backgroundColor: 'orange', //rgba(246, 112, 98, 0.8)
        padding: 10,
        flexDirection: 'row',
        justifyContent: 'space-around',
    },
    headerText: {
        fontSize: 25,
    },
    add: { 
        width: 50, 
        backgroundColor: 'black', 
        height: 30,
    },
    notes: {
        marginVertical: 50,
        marginHorizontal: 30,
    },
    empty: {
        fontSize: 30,
        alignSelf: 'center',
        marginVertical: 100
    }
    
})

export default Notes;