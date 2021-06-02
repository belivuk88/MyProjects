import React from "react";
import { Table, Button, Form, ButtonGroup } from "react-bootstrap";
import "./../../index.css";
import TakmicenjeAxios from "../../apis/TakmicenjeAxios";


class Takmicenje extends React.Component {
    constructor(props) {
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
            formati: [],
            search: { formatId: -1, mestoOdrzavanja: "" },
            pageNo: 0,
            totalPages: 2,
            active: true
        };
    }

    componentDidMount() {
        this.getData();
    }

    async getData() {
        await this.getFormati();
        await this.getTakmicenja(0);
    }

    async getTakmicenja(page) {
        let config = {
            params: {
                pageNo: page
            }
        };

        if (this.state.search.formatId != -1) {
            config.params.formatId = this.state.search.formatId;
        }
        if(this.state.search.mestoOdrzavanja != "") {
            config.params.mestoOdrzavanja = this.state.search.mestoOdrzavanja;
        }
        try {
            let result = await TakmicenjeAxios.get("/takmicenja", config);
            if (result && result.status === 200) {
                this.setState({
                    pageNo: page,
                    takmicenja: result.data,
                    totalPages: result.headers["total-pages"],
                });
            }
        } catch (error) {
            alert("Nije uspelo dobavljanje");
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

    goToPrijava(takmicenjeId) {
        this.props.history.push("/takmicenja/prijava/" + takmicenjeId);
    }

    async doDelete(takmicenjeId) {
        try {
            await TakmicenjeAxios.delete("/takmicenja/" + takmicenjeId);
            this.getTakmicenja(0);
        } catch (error) {
            alert("Nije uspelo brisanje.");
        }
    }

    searchValueInputChange(event) {
        let control = event.target;

        let name = control.name;
        let value = control.value;

        let search = this.state.search;
        search[name] = value;

        this.setState({ search: search });
    }

    doSearch() {
        this.getTakmicenja(0);
    }

    hiddenForm(){
        const currentState = this.state.active;
        this.setState({ active : !currentState});
    }



    render() {
        return (
            <div>
                <h1>Takmicenja</h1>

                <Form style={{ marginTop: 35 }}>
                    <Form.Group>
                        <Form.Label>Format</Form.Label>
                        <Form.Control
                            onChange={(e) => this.searchValueInputChange(e)}
                            onClick={() => this.doSearch()}
                            value={this.state.search.formatId}
                            name="formatId"
                            as="select"
                        >
                            <option value={-1}></option>
                            {this.state.formati.map((format) => {
                                return (
                                    <option value={format.id} key={format.id}>
                                        {format.tip}
                                    </option>
                                );
                            })}
                        </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Mesto odrzavanja</Form.Label>
                        <Form.Control
                            value={this.state.search.mestoOdrzavanja}
                            name="mestoOdrzavanja"
                            as="input"
                            onChange={(e) => this.searchValueInputChange(e)}
                            onKeyUp={() => this.doSearch()}>
                        </Form.Control>
                    </Form.Group>
                    
                </Form>

                <ButtonGroup style={{ marginTop: 25 }}>
                    <Button
                        disabled={this.state.pageNo == 0} onClick={() => this.getTakmicenja(this.state.pageNo - 1)}>
                        Prethodna
                    </Button>
                    <Button
                        disabled={this.state.pageNo == this.state.totalPages - 1} onClick={() => this.getTakmicenja(this.state.pageNo + 1)}>
                        Next
                    </Button>
                </ButtonGroup>

                <Table bordered striped style={{ marginTop: 5 }}>
                    <thead className="thead-dark">
                        <tr>
                            <th>Naziv</th>
                            <th>Mesto odrzavanja</th>
                            <th>Datum pocetka</th>
                            <th>Datum zavrsetka</th>
                            <th>Format</th>
                            <th colSpan={2}>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.takmicenja.map((takmicenje) => {
                            return (
                                <tr key={takmicenje.id}>
                                    <td>{takmicenje.naziv}</td>
                                    <td>{takmicenje.mestoOdrzavanja}</td>
                                    <td>{takmicenje.datumPocetka}</td>
                                    <td>{takmicenje.datumZavrsetka}</td>
                                    <td>{takmicenje.formatTip}</td>
                                    <td>
                                        <Button
                                            disabled={takmicenje.formatId === 5}
                                            variant="info"
                                            onClick={() => this.goToPrijava(takmicenje.id)}>
                                            Prijavi se
                                </Button>

                                        <Button
                                            variant="danger"
                                            onClick={() => this.doDelete(takmicenje.id)}
                                            style={{ marginLeft: 5 }}>
                                            Obriši
                                </Button>
                                    </td>
                                </tr>
                            );
                        })}
                    </tbody>
                </Table>
            </div>
        );
    }
}

export default Takmicenje;