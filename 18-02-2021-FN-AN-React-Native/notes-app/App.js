import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';
import Login from './src/screens/Login';
import Notes from './src/screens/Notes/Notes';
import AddNotes from './src/screens/Notes/AddNotes';

const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Login" component={Login}  />
        <Stack.Screen name="Home" component={Notes}  />
        <Stack.Screen name="AddNotes" component={AddNotes} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

