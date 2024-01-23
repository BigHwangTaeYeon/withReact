import {useEffect, useState} from "react";
import axios from "axios";

function App() {
    const [hello1, setHello] = useState('');

    useEffect(() => {
        axios.get('/api/test')
            .then((res) => {
                setHello(res.data);
            })
    }, []);
    return (
        <div className="App">
            백엔드 데이터 : {hello1}
        </div>
    );

    const [data, setData] = useState([]);
  
    useEffect(() => {
      fetch("/api/test123")
          .then((res) => {
            return res.json();
          })
          .then(function (result) {
              setData(result);
        })
    },[]);
  
    return (
      <div className="App">
          <ul>
              {data.map((v,idx)=><li key={`${idx}-${v}`}>{v}</li>)}
          </ul>
      </div>
    );
}

export default App;