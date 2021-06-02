import React from "react";
import {Button, Form} from "react-bootstrap";

import TakmicenjeAxios from "../../apis/TakmicenjeAxios";

class AddTakmicenje extends React.Component {
    constructor(props){
        super(props);

        let takmicenje = {
            naziv: "",
            mestoOdrzavanja: "",
            datumPocetka: "",
            datumZavrsetka: "",
            formatId: -1,
        };

        this.state = {
            takmicenje: takmicenje,
            takmicenja: [],
            formati: []

    };
}

    componentDidMount(){
     this.getData();

    }

    async getData(){
        await this.getFormati();
        await this.getTakmicenja();

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

    async getFormati() {
        try {
            let result = await TakmicenjeAxios.get("/formati");
            if (result && result.status === 200) {
                this.setState({
                    formati: result.data,
                });
            }
        } catch (error) {
            alert("Nije uspelo dobavljanje");
        }
    }

    async doAdd() {
        try {
            await TakmicenjeAxios.post("/takmicenja", this.state.takmicenje);

            // let takmicenje = {
            //     naziv: "",
            //     mestoOdrzavanja: "",
            //     datumPocetka: "",
            //     datumZavrsetka: "",
            //     formatId: -1,
            // };
            // this.setState({ takmicenje: takmicenje })

            // this.getTakmicenja(0);
            this.props.history.push("/takmicenja");
        } catch (error) {
            alert("Nije uspelo dodavanje.");
        }
    }

    addValueInputChange(event) {
        let control = event.target;

        let name = control.name;
        let value = control.value;

        let takmicenje = this.state.takmicenje;
        takmicenje[name] = value;

        this.setState({ takmicenje: takmicenje });
    }

    render() {
        return (
            <div>
                <h1>Takmicenja</h1>
                <Form>
                    <Form.Group>
                        <Form.Label>Naziv takmicenja</Form.Label>
                        <Form.Control
                            onChange={(event) => this.addValueInputChange(event)}
                            name="naziv"
                            value={this.state.takmicenje.naziv}
                            as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Mesto Odrzavanja</Form.Label>
                        <Form.Control
                            onChange={(event) => this.addValueInputChange(event)}
                            name="mestoOdrzavanja"
                            value={this.state.takmicenje.mestoOdrzavanja}
                            as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Datum Pocetka</Form.Label>
                        <Form.Control
                            onChange={(event) => this.addValueInputChange(event)}
                            name="datumPocetka"
                            value={this.state.takmicenje.datumPocetka}
                            as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Datum zavrsetka</Form.Label>
                        <Form.Control
                            onChange={(event) => this.addValueInputChange(event)}
                            name="datumZavrsetka"
                            value={this.state.takmicenje.datumZavrsetka}
                            as="input">
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Format</Form.Label>
                        <Form.Control
                            onChange={(event) => this.addValueInputChange(event)}
                            name="formatId"
                            value={this.state.takmicenje.formatId}
                            as="select">
                            <option value={-1}></option>
                            {this.state.formati.map((format) => {
                                return (
                                    <option value={format.id} key={format.id}>
                                        {format.tip}
                                    </option>
                                );
                            })};
                        </Form.Control>
                    </Form.Group>
                    <Button variant="primary" onClick={() => this.doAdd()}>
                        Kreiraj Takmicenje
                    </Button>
                </Form>
                </div>
        );
    }

}

export default AddTakmicenje;