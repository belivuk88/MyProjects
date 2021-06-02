import React from "react";
import { Button, Form } from "react-bootstrap";

import TakmicenjeAxios from "../../apis/TakmicenjeAxios";

class Prijava extends React.Component {
  constructor(props) {
    super(props);

    let takmicenje = {
      naziv: "",
      mestoOdrzavanja: "",
      datumPocetka: "",
      datumZavrsetka: "",
      formatId: -1,
  };

    let prijava = {
      drzava: "",
      eMail: "",
      datumPrijave: "",
      takmicenjeId: this.props.match.params.id,
  };

    this.state = {
      takmicenje: takmicenje,
      prijava: prijava,
      prijave:[],
      takmicenja: [],
    };
  }

  componentDidMount() {
    this.getData();
  }

  async getData() {
    await this.getTakmicenja();
    await this.getPrijave();
  }

  async getTakmicenja(){
    try{
        let takmicenje = this.state.takmicenje;
        let takmicenjeDTO = {
            naziv: takmicenje.naziv,
            mestoOdrzavanja : takmicenje.mestoOdrzavanja,
            datumPocetka: takmicenje.datumPocetka,
            datumZavrsetka: takmicenje.datumZavrsetka,
            formatId: takmicenje.formatId
    }
    
        let result = await TakmicenjeAxios.get("/takmicenja" , takmicenjeDTO);
        if(result && result.status === 200){
            this.setState({
                takmicenja: result.data
            });
        }
    } catch(error){
        alert("Nije uspelo dobavljanje.");
    }
}

  async getPrijave() {
    try {
      let prijava = this.state.prijava;
      let prijavaDTO = {
        drzava: prijava.drzava,
        eMail: prijava.eMail,
        datumPrijave: prijava.datumPrijave,
        takmicenjeId: prijava.takmicenjeId
      }
      let result = await TakmicenjeAxios.get("/prijave", prijavaDTO);
      if (result && result.status === 200) {
        this.setState({
          prijave: result.data,
        });
      }
    } catch (error) {
      alert("Nije uspelo dobavljanje.");
    }
  }



  valueInputChange(event) {
    let control = event.target;

    let name = control.name;
    let value = control.value;

    let prijava = this.state.prijava;
    prijava[name] = value;

    this.setState({ prijava: prijava });
  }

  async prijaviSe() {
    try {
    await TakmicenjeAxios.post(`/takmicenja/${this.props.match.params.id}/prijavi_se`,
    this.state.prijava);
    this.getTakmicenja(0);
    } catch (error) {
    alert("Nije moguce promeniti stanje.");
    }
    }

  render() {
    return (
      <div>
        <h1>Prijava</h1>

        <Form>
          <Form.Group>
            <Form.Label>Drzava</Form.Label>
            <Form.Control
              onChange={(event) => this.valueInputChange(event)}
              name="drzava"
              value={this.state.prijava.drzava}
              as="input"
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>EMail</Form.Label>
            <Form.Control
              onChange={(event) => this.valueInputChange(event)}
              name="eMail"
              value={this.state.prijava.eMail}
              as="input"
            ></Form.Control>
          </Form.Group>
          <Button variant="primary" onClick={() => this.prijaviSe()}>
            Prijava
          </Button>
        </Form>

      </div>
    );
  }
}

export default Prijava;