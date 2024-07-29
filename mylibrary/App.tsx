import React, {useCallback, useEffect, useState} from 'react';
import {
  NativeModules,
  SafeAreaView,
  StyleSheet,
  View,
  Text,
  TextInput
} from 'react-native';

interface MyModuleProps {
  callFragmentMethod: (value: string) => void;
}

const { MyNativeModule } = NativeModules
const { callFragmentMethod }: MyModuleProps = MyNativeModule;

const onChange = (inputValue: string) => {
  callFragmentMethod(inputValue);
};

interface Props {
  inputText: string;
}

function App(props: Props): React.JSX.Element {
  const [inputValue, setInputValue] = useState(props.inputText);
  const [inputValue2, setInputValue2] = useState('');

  const onChangeHandler = useCallback((value: string) => {
    setInputValue(value);
    onChange(value)
  }, [])

  useEffect(() => {
    setInputValue(props.inputText);
  }, [props.inputText]);

  return (
      <View style={styles.container}>
        <View style={styles.inputContainer}>
          <Text style={styles.text}>Írj be valamit:</Text>
          <TextInput
              style={styles.input}
              placeholder="Írd be a szöveget"
              value={inputValue}
              onChangeText={onChangeHandler}
          />
        </View>
        <View style={styles.inputContainer}>
          <Text style={styles.text}>Írj be valamit mast is:</Text>
          <TextInput
              style={styles.input}
              placeholder="Írd be a szöveget"
              value={inputValue2}
              onChangeText={setInputValue2}
          />
        </View>
      </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1, justifyContent: 'center', alignItems: 'center'
  },
  inputContainer: {
    width: '100%',
    padding: 10,
  },
  text: {
    fontSize: 18,
    marginBottom: 20,
  },
  input: {
    height: 40,
    borderColor: 'gray',
    borderWidth: 1,
    marginBottom: 20,
    paddingHorizontal: 10,
    width: '100%',
  },
});

export default App;
